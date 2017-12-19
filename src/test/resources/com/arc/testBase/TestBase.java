package com.arc.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import java.util.List;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;

import com.arc.excelReader.Xls_Reader;
import com.arc.testUtills.Utills;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestBase extends Utills{
	public static Properties Repository = new Properties();
	public File f;
	public FileInputStream FI;
	public Xls_Reader Data;
	
	public static ExtentTest logger;
	public static ExtentReports report = new ExtentReports(System.getProperty("user.dir")
		        + "\\src\\com\\arc\\extendedReport\\STG-ARC-EXTENDEDREPORT.html");
	
	@BeforeClass
	public void init() throws IOException{
		loadPropertiesFile();
		selectBrowser(Repository.getProperty("browser"));
		impliciteWait(30);
		driver.get(Repository.getProperty("url"));
	}
	
	public void loadPropertiesFile() throws IOException {
		f = new File(System.getProperty("user.dir")+"\\src\\com\\arc\\config\\config.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
		f = new File(System.getProperty("user.dir")+"\\src\\com\\arc\\pageLocators\\BuildingsPage\\landingPage.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
		f = new File(System.getProperty("user.dir")+"\\src\\com\\arc\\pageLocators\\BuildingsPage\\projRegPage.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
	    f = new File(System.getProperty("user.dir")+"\\src\\com\\arc\\pageLocators\\BuildingsPage\\paymentPage.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
		f = new File(System.getProperty("user.dir")+"\\src\\com\\arc\\pageLocators\\BuildingsPage\\teamPage.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
		f = new File(System.getProperty("user.dir")+"\\src\\com\\arc\\pageLocators\\BuildingsPage\\dashbord.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
		f = new File(System.getProperty("user.dir")+"\\src\\com\\arc\\pageLocators\\CityCommunityPage\\landingPage.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
		
		f = new File(System.getProperty("user.dir")+"\\src\\com\\arc\\pageLocators\\BuildingsPage\\preCert.properties");
		FI = new FileInputStream(f);
		Repository.load(FI);
			
	}
	
	public  WebElement getLocator(String locator) throws Exception {
        String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];

		if (locatorType.toLowerCase().equals("id"))
			return driver.findElement(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElement(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname"))
				|| (locatorType.toLowerCase().equals("class")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname"))
				|| (locatorType.toLowerCase().equals("tag")))
			return driver.findElement(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext"))
				|| (locatorType.toLowerCase().equals("link")))
			return driver.findElement(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElement(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector"))
				|| (locatorType.toLowerCase().equals("css")))
			return driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElement(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}
	
	public  List<WebElement> getLocators(String locator) throws Exception {
        String[] split = locator.split(":");
		String locatorType = split[0];
		String locatorValue = split[1];

		if (locatorType.toLowerCase().equals("id"))
			return driver.findElements(By.id(locatorValue));
		else if (locatorType.toLowerCase().equals("name"))
			return driver.findElements(By.name(locatorValue));
		else if ((locatorType.toLowerCase().equals("classname"))
				|| (locatorType.toLowerCase().equals("class")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("tagname"))
				|| (locatorType.toLowerCase().equals("tag")))
			return driver.findElements(By.className(locatorValue));
		else if ((locatorType.toLowerCase().equals("linktext"))
				|| (locatorType.toLowerCase().equals("link")))
			return driver.findElements(By.linkText(locatorValue));
		else if (locatorType.toLowerCase().equals("partiallinktext"))
			return driver.findElements(By.partialLinkText(locatorValue));
		else if ((locatorType.toLowerCase().equals("cssselector"))
				|| (locatorType.toLowerCase().equals("css")))
			return driver.findElements(By.cssSelector(locatorValue));
		else if (locatorType.toLowerCase().equals("xpath"))
			return driver.findElements(By.xpath(locatorValue));
		else
			throw new Exception("Unknown locator type '" + locatorType + "'");
	}
	
	public  WebElement getWebElement(String locator) throws Exception{
		return getLocator(Repository.getProperty(locator));
	}
	
	public  List<WebElement> getWebElements(String locator) throws Exception{
		return getLocators(Repository.getProperty(locator));
	}
	/*@AfterClass
	public void closeBrowser()
	{
	driver.close();
	}*/
	
	public Object[][] getData(String ExcelName, String testcase) {
		Data = new Xls_Reader(System.getProperty("user.dir") + "//src//com//arc//testData//"+ExcelName);
		int rowNum = Data.getRowCount(testcase);
		System.out.println(rowNum);
		int colNum = Data.getColumnCount(testcase);
		Object sampleData[][] = new Object[rowNum - 1][colNum];
		for (int i = 2; i <= rowNum; i++) {
			for (int j = 0; j < colNum; j++) {
				sampleData[i - 2][j] = Data.getCellData(testcase, j, i);
			}
		}
		return sampleData;
	}
	@BeforeTest
	public void startReport()
	{	
		report.addSystemInfo("HostName","Saurav")
		.addSystemInfo("Environment","ArcTest");
		report.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		

		
	}
    @AfterMethod
	public void afterMethod(ITestResult result)
	{
		
			if(result.getStatus()==ITestResult.FAILURE)
			{
			logger.log(LogStatus.FAIL,result.getThrowable());
			}
			report.endTest(logger);
			report.flush(); 
	}
   
    
}
