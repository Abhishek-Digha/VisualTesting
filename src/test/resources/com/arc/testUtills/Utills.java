package com.arc.testUtills;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class Utills {
	public static WebDriver driver;
	public static WebDriver selectBrowser(String browser){
		if (browser.equals("firefox") || browser.equals("FIREFOX")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			return driver;
		} else if (browser.equals("chrome") || browser.equals("CHROME")) {
			System.out.println("chrome browser stared");
			System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "\\src\\com\\arc\\browsersDrivers\\chromedriver.exe");

			driver = new ChromeDriver();
			driver.manage().window().maximize();
			return driver;
		} else if(browser.equals("ie") || browser.equals("IE")) {
			System.out.println("IE Browser started");
			System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+ "\\src\\com\\arc\\browsersDrivers\\IEDriverServer.exe");

			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			return driver;
		}
		else 
		return null;
	}
	
	public void impliciteWait(int timeInsec){
		Reporter.log("waiting for page to load...");
		try{
		driver.manage().timeouts().implicitlyWait(timeInsec, TimeUnit.SECONDS);
		Reporter.log("Page is loaded");
		}
		catch(Throwable error){
			Reporter.log("Timeout for Page Load Request to complete after "+ timeInsec + " seconds");
			Assert.assertTrue(false, "Timeout for page load request after "+timeInsec+" second");
		}
	}
	
	public void seleteDropDownValue(WebElement element, String dropDownValue){
		Select select = new Select(element);
		Reporter.log("selecting "+dropDownValue+" value in dropdown");
		select.selectByVisibleText(dropDownValue);
	}
	
	public void driverwait(int timeToWaitInSec) throws InterruptedException{
		Reporter.log("waiting for "+timeToWaitInSec+" seconds...");
		Thread.sleep(timeToWaitInSec*1000);
	}
	
	public static void expliciteWait(WebElement element, int timeToWaitInSec) {
		WebDriverWait wait = new WebDriverWait(driver, timeToWaitInSec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
