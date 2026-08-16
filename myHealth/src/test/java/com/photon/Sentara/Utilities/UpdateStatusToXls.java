package com.test.test2.Utilities;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

public class UpdateStatusToXls {

	Logger log = Logger.getLogger(this.getClass().getSimpleName());
	
	public JSONArray getHeaderData() {
		JSONArray header = new JSONArray();
		header.put("Test Case ID");
		header.put("Linked Issue ID");
		header.put("Issue Status");
		header.put("Automation Status");
		log.info("Header Data returned");
		return header;
	}

	@SuppressWarnings("deprecation")
	private Map<String, Object> borderStyle(){		
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put(CellUtil.BORDER_LEFT, CellStyle.BORDER_MEDIUM);
		properties.put(CellUtil.BORDER_RIGHT, CellStyle.BORDER_MEDIUM);
		properties.put(CellUtil.BORDER_BOTTOM, CellStyle.BORDER_MEDIUM);
		properties.put(CellUtil.BORDER_TOP, CellStyle.BORDER_MEDIUM);		
		return properties;
	}
	
	@SuppressWarnings("resource")
	public void writeDataInExcel(JSONObject xlsData) throws FileNotFoundException, IOException {
//		String response = "{\"Login Page\":{\"CA-355\":{\"testcaseid\":\"CA-355\",\"change\":[\"\",\"New\",\"\",\"Screen Shot Modified\"],\"linkedissueid\":[\"\",\"CA-1558\",\"\",\"CA-1557\"],\"issuestatus\":[\"\",\"QA\",\"\",\"To Do\"]},\"header\":[\"Test Case ID\",\"Linked Issue ID\",\"Issue Status\",\"Automation Status\"],\"CA-354\":{\"testcaseid\":\"CA-354\",\"change\":[\"Screen Shot Modified\",\"\"],\"linkedissueid\":[\"CA-1559\",\"\"],\"issuestatus\":[\"To Do\",\"\"]}}}";
		JSONObject obj = new JSONObject();		
		obj = xlsData;
		Map<String, Object> borderStyle = new HashMap<String, Object>();
		borderStyle = borderStyle();
		XSSFWorkbook workbook = new XSSFWorkbook();
		int rowCount = 1;
		for (String sheetName : obj.keySet()) {
			XSSFSheet sheet = workbook.createSheet(sheetName);
			int columnCount = 0;
			Row row;
			Cell cell;
			for (String key : obj.getJSONObject(sheetName).keySet()) {
				if (key.equals("header")) {
					row = sheet.createRow(0);
					for (Object field : obj.getJSONObject(sheetName)
							.getJSONArray("header")) {
						cell = row.createCell(columnCount);
						CellUtil.setCellStyleProperties(cell, borderStyle);
						if (field instanceof String) {
							cell.setCellValue((String) field);
						} else if (field instanceof Integer) {
							cell.setCellValue((Integer) field);
						}
						columnCount++;
					}
					columnCount = 0;
				} else {
					JSONObject testData = obj.getJSONObject(sheetName)
							.getJSONObject(key);
					JSONArray changeArray = testData.getJSONArray("change");
					JSONArray linkedissueidArray = testData
							.getJSONArray("linkedissueid");
					JSONArray issuestatusArray = testData
							.getJSONArray("issuestatus");
					for (int i = 0; i < changeArray.length(); i++) {
						if (!linkedissueidArray.get(i).equals("")) {
							row = sheet.createRow(rowCount);
							cell = row.createCell(0);
							CellUtil.setCellStyleProperties(cell, borderStyle);
							cell.setCellValue((String) testData
									.getString("testcaseid"));
							cell = row.createCell(1);
							CellUtil.setCellStyleProperties(cell, borderStyle);
							cell.setCellValue((String) linkedissueidArray
									.get(i));
							cell = row.createCell(2);
							CellUtil.setCellStyleProperties(cell, borderStyle);
							cell.setCellValue((String) issuestatusArray.get(i));
							cell = row.createCell(3);
							CellUtil.setCellStyleProperties(cell, borderStyle);
							cell.setCellValue((String) changeArray.get(i));
							rowCount++;
						}
					}
					columnCount = 0;
				}
			}

			try (FileOutputStream outputStream = new FileOutputStream(
					"Jira_Defect_Status.xlsx")) {
				workbook.write(outputStream);
				log.info("Data written into Excel file");
			}
		}

	}

//	public static void main(String[] args) throws FileNotFoundException,
//			IOException {
//		UpdateStatusToXls update = new UpdateStatusToXls();
////		update.writeDataInExcel();
//	}
}
