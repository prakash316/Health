package com.testProject.Sentara.Trigger;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;


import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.cucumber.listener.Reporter;
import com.testProject.Sentara.Utilities.BaseStep;
import com.testProject.Sentara.Utilities.CucumberJsonDataExtractor;
import com.testProject.Sentara.Utilities.TestCaseMgmtCloud;
import com.testProject.Sentara.Utilities.UpdateStatusToXls;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features = "src/test/resources", glue = {
		"com.test.test2.StepDefinition", "com.test.test2.Trigger"}, monochrome = true, plugin = {
		"pretty", "html:target/Report/cucumber",
		"json:target/cucumber/report.json",
		"usage:target/cucumber/cucumber-usage.json",
		"com.cucumber.listener.ExtentCucumberFormatter:" }, tags = {"@websmokeTest" })
public class SmokeTest extends AbstractTestNGCucumberTests {
	
	Logger log = Logger.getLogger(this.getClass().getSimpleName());
	BaseStep base = new BaseStep();	
	public static String reportFilePath;
	String breakPoint;
	String deviceOS;		
	String appUrl;
	String appiumHost;
	String status;
	String tagName;
	static HashMap<String, String> scenarioStatus = new HashMap<String, String>();
	static HashMap<String, String> attachmentPath = new HashMap<String, String>();
	static HashMap<String, String> priority = new HashMap<String, String>();
	static List<String> stepName = null;	
	
	@After
	public void takeScreenShotonFailure(Scenario scenario) throws Exception {
		status = scenario.getStatus();		
		Collection<String> tags = scenario.getSourceTagNames();
		for (String tag : tags) {	
			if (tag.toLowerCase().startsWith("@"+BaseStep.config.getString("project.key").toLowerCase())) {
				scenarioStatus.put(tag, status);
				String path = base.takeScreenShotonFailure(scenario, reportFilePath);
				attachmentPath.put(tag, path);				
			}
		}		
	}

	@BeforeSuite
	public void initialize() {
		try {			
			base.initialize();
			log.info("Property File Initialized");
			if(System.getProperty("deviceOS")!=null){
				breakPoint=System.getProperty("breakPoint");
				deviceOS=System.getProperty("deviceOS");
				appUrl=System.getProperty("appUrl");
				appiumHost=System.getProperty("appiumHost");
				log.info("deviceOS" +deviceOS);
			}else{
				breakPoint=BaseStep.config.getString("breakPoint");
				deviceOS=BaseStep.config.getString("deviceOS");
				appUrl=BaseStep.config.getString("appUrl");
				appiumHost=BaseStep.config.getString("appiumHost");				
			}
		} catch (Exception | Error e) {
			log.info(e.getStackTrace());
		}
	}

	@Parameters({"browser"})
	@BeforeTest
	public void setup(String browser) throws Exception {		
		try {			
			reportFilePath = BaseStep.curdir + File.separator + "output"
					+ File.separator + this.getClass().getSimpleName()
					+ File.separator + deviceOS.toUpperCase();
			File path = new File(reportFilePath);
			if (path.exists()) {
				FileUtils.deleteDirectory(new File(reportFilePath));
			}
			base.reportSetup(reportFilePath + File.separator + "report.html");
			log.info("Extended Cucumber Report Setup Done");			
			log.info("breakPoint " +breakPoint);			
			if (breakPoint.equalsIgnoreCase("MobileApp"))
			{					
				base.LaunchApp(deviceOS,appiumHost);				
			} else {
				base.IntitateBrowser(breakPoint,browser,deviceOS,appiumHost,appUrl);
			}
		} catch (IOException | InterruptedException e) {			
			e.printStackTrace();
		}
	}
	
	@Parameters({"browser"})
	@AfterTest
	public void shutDown(String browser) throws Exception {
		Reporter.loadXMLConfig(new File("src/main/resources/Report.xml"));
		Reporter.setSystemInfo("user", System.getProperty("user.name"));
		Reporter.setSystemInfo("os", System.getProperty("os.name"));
		if (breakPoint.equalsIgnoreCase("Desktop")) {
			Reporter.setSystemInfo("Browser", browser);
		} else {
			Reporter.setSystemInfo("Browser", this.deviceOS);
		}		
		base.closeDriver(breakPoint);				
	}

	@SuppressWarnings("unused")
	@AfterSuite
	public void jiraUpdate() throws Exception{
		if(false){
//			if(BaseStep.AUTOEXECTIONSTATUS){
			log.info("Jira Update is Started");
			TestCaseMgmtCloud Tcm = new TestCaseMgmtCloud();		
			CucumberJsonDataExtractor extractor = new CucumberJsonDataExtractor();
			UpdateStatusToXls xls = new UpdateStatusToXls();
			JSONArray cucumberJson = extractor.readData();		
			JSONObject result = extractor.getScenarioStatus(cucumberJson);
			JSONObject xlsDataObject = new JSONObject();
			JSONObject featureObject = new JSONObject();
			System.out.println(priority);
			for(String obj:result.keySet()){
				JSONObject scenarioObj = result.getJSONObject(obj);			
				for(String tag:scenarioStatus.keySet()){
					JSONObject stepDetailsObj = scenarioObj.getJSONObject(tag);
					tagName = tag.replace("@", "").trim();
					String cycleId = Tcm.getCycleId();
					int issueId = Tcm.getIssueId(tagName);
					featureObject.put(tagName, Tcm.updateExecutioStatus(attachmentPath,priority.get(tag),tagName, scenarioStatus.get(tag),stepDetailsObj,cycleId,issueId));
				}
				featureObject.put("header", xls.getHeaderData());
				xlsDataObject.put(obj, featureObject);
			}	
			xls.writeDataInExcel(xlsDataObject);
			log.info("Jira Updation completed");						
		}else{
			log.info("Driver initialization is not done properly skipping jira updation");
		}		
	}
}
