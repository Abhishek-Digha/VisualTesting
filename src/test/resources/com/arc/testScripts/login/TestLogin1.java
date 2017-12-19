package com.arc.testScripts.login;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.arc.pageLibrary.loginLogoutPage.LoginLogoutPage;
import com.arc.testBase.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TestLogin1 extends TestBase{
	ExtentReports report = new ExtentReports(System.getProperty("user.dir")
			+ "\\src\\com\\arc\\extendedReport\\LoginReport.html");
	ExtentTest logger;
	
	@BeforeClass
	public void setUp() throws IOException{
		init();
	}
	
	@Test
	public void testLogin1() throws Exception{
	    logger = report.startTest("verify login");
		LoginLogoutPage login=new LoginLogoutPage();
		Reporter.log("Click on login");
		login.loginToApplication();
		logger.log(LogStatus.INFO, "Login Is successfule");
		
		boolean text= true;
		SoftAssert assertion = new SoftAssert();
		assertion.assertEquals("Arc dashboard", driver.getTitle());
		//Assert.assertEquals("dashboard", driver.getTitle(), "Title match Successully");
		assertion.assertEquals(true,false);
		assertion.assertTrue(text,"text condition true");
		assertion.assertFalse(text,"Text condition false");
		logger = report.startTest("verify logout");
		login.logoutToApplication();
		logger.log(LogStatus.INFO, "Logout Is successfule");	
		
	}
	
	@AfterClass
	public void testDown(){
		closeBrowser();
	}

	@BeforeTest
	public void startReport()
	{	
		
		report.addSystemInfo("HostName","Saurav")
		.addSystemInfo("Environment","ArcTest");
		report.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));
		logger=report.startTest("VerifyBlogTitle2");
		logger.log(LogStatus.INFO, "Browser started ");
		logger.log(LogStatus.INFO, "Application is up and running");
		logger.log(LogStatus.INFO, "Login Is successfule");
		
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
	@Test
	public void demoReportPass()
	{
		logger=report.startTest("demoReportPass");
		Assert.assertTrue(true);
		logger.log(LogStatus.PASS, "Assert Pass");
	
	}
	@Test
	public void demoReportFail()
	{
		logger=report.startTest("demoReportFail");
		Assert.assertTrue(true);
		logger.log(LogStatus.INFO, "Closeed  ");
		logger.log(LogStatus.INFO, "Browser Thored ");
		logger.log(LogStatus.INFO, "Browser closed ");
		logger.log(LogStatus.FAIL, "Assert Fail");
		
	}
	
}
