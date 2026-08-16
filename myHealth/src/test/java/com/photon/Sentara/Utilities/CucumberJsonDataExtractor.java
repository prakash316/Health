package com.test.test2.Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;


public class CucumberJsonDataExtractor extends BaseStep{

	
	public JSONArray readData() throws IOException{
		JSONArray cucumberJson = null;
		File file = new File("./target/cucumber/report.json");
	    String content = FileUtils.readFileToString(file, "utf-8");	    
	    // Convert JSON string to JSONObject
	    cucumberJson  = new JSONArray(content);	    
	    return cucumberJson;
	}
	
	public JSONArray readData(String path) throws IOException{
		JSONArray cucumberJson = null;
		File file = new File(path);
	    String content = FileUtils.readFileToString(file, "utf-8");	    
	    // Convert JSON string to JSONObject
	    cucumberJson  = new JSONArray(content);	    
	    return cucumberJson;
	}
	
	public JSONObject getScenarioStatus(JSONArray jsonArray){
		JSONObject result = new JSONObject();		
		for (Object object : jsonArray) {
			JSONObject tagObject = new JSONObject();			
			JSONObject obj = (JSONObject) object;
			JSONArray scenario = obj.getJSONArray("elements");				
			for(Object arr:scenario){	
				JSONObject details = new JSONObject();
				String summary = "";
				String description = "";
				JSONObject scenarioObj = (JSONObject) arr;
				summary = scenarioObj.getString("name");
				JSONArray stepsArray = scenarioObj.getJSONArray("steps");
				JSONArray tags = scenarioObj.getJSONArray("tags");
				String tagName = "";
				for(Object tag :tags){
					JSONObject tagList = (JSONObject) tag;					
					if(tagList.getString("name").toLowerCase().startsWith("@ca")){
						tagName = tagList.getString("name");
						break;
					}
				}				
				JSONArray stepStatusList = new JSONArray();
				String step = "";
				for(Object stepObj:stepsArray){
					JSONObject steps = (JSONObject) stepObj;					
					String stepStatus = steps.getJSONObject("result").getString("status");					
					if(!stepStatus.equals("skipped")){
						step =  step+steps.getString("name").replace("\"", "'")+",";
						if(stepStatus.equals("failed")){
							description = steps.getString("name");							
						}
					}
					stepStatusList.put(stepStatus);				
				}		
				details.put("summary", summary);
				details.put("description", description);
				details.put("steps", step);
				details.put("status", stepStatusList);
				tagObject.put(tagName, details);
				result.put(obj.getString("name"), tagObject);
			}			
		}
		return result;
	}
	
	public static void main(String[] args) throws IOException{
		CucumberJsonDataExtractor extractor = new CucumberJsonDataExtractor();
		JSONArray cucumberJson = extractor.readData("/Users/kpmg-bench/Downloads/Consolidated_Framework/mytest2_ios/Automation/target/cucumber/report.json");
		JSONObject result = extractor.getScenarioStatus(cucumberJson);		
		System.out.println(result);
		System.out.println(result.getJSONObject("Login Page").getJSONObject("@CA-355"));		
	}
	
}
