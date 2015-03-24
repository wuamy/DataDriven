package executionEngine;

/**
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
*/

import config.ActionKeywords;
import utility.ExcelUtils;
//import dataEngine.*;

public class DriverScript {
	//private static WebDriver driver = null;
	
	public static void main(String[] args) throws Exception{
		
		//declaring the path of the excel file with the name of the excel file
		String sPath = "C://ToolsQA//DataDriven//src//dataEngine//DataEngine.xlsx";
		
		//passing the excel path and s sheetname
		ExcelUtils.setExcelFile(sPath, "Sheet1");
		
		//hard coded values are used for excel row & column for now
		//later we will replace these values with variables
		//loop for reading the values of the column 3
		for (int iRow=1; iRow<=9; iRow++){
			//storing the value
			String sActionKeyword = ExcelUtils.getCellData(iRow, 3);
			
		//Comparing the value of excel with all the project keyworks
		if(sActionKeyword.equals("openBrowser")) {
			ActionKeywords.openBrowser();
		}
		else if(sActionKeyword.equals("navigate")){
			ActionKeywords.navigate();
		}
		else if(sActionKeyword.equals("click_MyAccount")){
			ActionKeywords.click_MyAccount();
		}
		else if(sActionKeyword.equals("input_Username")){
			ActionKeywords.input_Username();
		}
		else if(sActionKeyword.equals("input_Password")){
			ActionKeywords.input_Password();
		}
		else if(sActionKeyword.equals("click_Login")){
			ActionKeywords.click_Login();
		}
		else if(sActionKeyword.equals("waitfor")){
			ActionKeywords.waitfor();
		}
		else if(sActionKeyword.equals("click_Logout")){
			ActionKeywords.click_Logout();
		}
		else if(sActionKeyword.equals("closeBrowser")){
			ActionKeywords.closeBrowser();
		}
		
		
	}
		
		
		/**
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.store.demoqa.com");
		
		
		// login 
		driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		driver.findElement(By.id("log")).sendKeys("daniel");
		driver.findElement(By.id("pwd")).sendKeys("uO8yX6uPbEqZ");
		driver.findElement(By.id("login")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id='meta']/ul/li[2]/a")).click();
		driver.quit();
		 */
	}

}
