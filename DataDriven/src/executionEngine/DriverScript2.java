package executionEngine;

import java.io.FileInputStream;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import config.ActionKeywords;
import utility.ExcelUtils;
import config.Constants;

public class DriverScript2 {
	
	public static Properties OR;
	public static ActionKeywords actionKeywords;
	public static String sActionKeyword;
	public static String sPageObject;
	
	
	public static void main(String[] args) throws Exception {
		
		InputStream input = null;
		
		//Class noparams[] = {};
		
		//declaring the path of the excel file with the name of the excel file
		//String sPath = "C://ToolsQA//DataDriven//src//dataEngine//DataEngine.xlsx";
		String sPath = Constants.Path_TestData;
		//ExcelUtils.setExcelFile(sPath, "Sheet1");
		ExcelUtils.setExcelFile(sPath, Constants.Sheet_TestSteps);
		
		//declaring string variable for store Object
		String PathOR = Constants.Path_OR;
		FileInputStream fs = new FileInputStream(PathOR);
		
		input = fs;
		
		//testing
		if(OR==null){
			System.out.println("sorry, unable to find" + input);
			
		}
		
		
		//creating an object of properties
		OR = new Properties(System.getProperties());
		//loading all the properties from Object repository property file in to Object
		OR.load(fs);
		
				
		for(int iRow = 1; iRow <=9; iRow++){
			sActionKeyword = ExcelUtils.getCellData(iRow, Constants.Col_ActionKeyword);
			sPageObject = ExcelUtils.getCellData(iRow, Constants.Col_PageObject);
			execute_Actions();
		}

	}
	
	private static void execute_Actions() throws Exception {
		Class cls = Class.forName("config.ActionKeywords");
		Object obj = cls.newInstance();
		Method method[] = cls.getMethods();
		for(int i = 0; i < method.length; i++){
			if(method[i].getName().equals(sActionKeyword)){
				//method[i].invoke(obj, null);
				method[i].invoke(actionKeywords, sPageObject);
				break;
			}
		}
	}

}
