package config;

import java.util.concurrent.TimeUnit;
import static executionEngine.DriverScript2.OR;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import config.Constants;

public class ActionKeywords {
	
	public static WebDriver driver;
	
	public static void openBrowser(String object){
		driver = new FirefoxDriver();
	}
	
	public static void navigate(String object){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//driver.get("http://www.store.demoqa.com");
		driver.get(Constants.URL);
	}
	
	public static void click_MyAccount(String object){
		//driver.findElement(By.xpath(".//*[@id='account']/a")).click();
		driver.findElement(By.xpath(OR.getProperty(object))).click();
			
	}
	
	public static void input_Username(String object){
		//driver.findElement(By.id("log")).sendKeys("daniel");
		//driver.findElement(By.id("log")).sendKeys(Constants.UserName);
		driver.findElement(By.id(OR.getProperty(object))).sendKeys(Constants.UserName);
		
	}
	
	public static void input_Password(String object){
		//driver.findElement(By.id("pwd")).sendKeys("uO8yX6uPbEqZ");
		//driver.findElement(By.id("pwd")).sendKeys(Constants.Password);
		driver.findElement(By.id(OR.getProperty(object))).sendKeys(Constants.Password);
		
	}
	
	public static void click_Login(String object){
		driver.findElement(By.id(OR.getProperty(object))).click();
	}
	
	public static void waitfor(){
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	
	public static void click_Logout(String object){
		driver.findElement(By.xpath(OR.getProperty(object))).click();
		
	}
	
	public static void closeBrowser(String object){
		driver.quit();
	}


}
