/*package com.arc.testScripts.login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.arc.pageLibrary.loginLogoutPage.LoginLogoutPage;

import com.arc.pageLibrary.teamPage.TeamPage;
import com.arc.testBase.TestBase;
public class TestLogin extends TestBase {

	@BeforeClass
	public void setUp() throws IOException {
		init();
	}

	@Test
	public void testLogin() throws Exception {
		System.out.println("Team Module Test");
		Set<String> homepage=driver.getWindowHandles();
		
		//System.out.println(homepage);
		LoginLogoutPage login = new LoginLogoutPage();
		TeamPage team=new TeamPage();
		login.loginToApplication();
		driverwait(3);
		
		team.ProjectDetailUploadOperatingHour();
		driverwait(3);
		ProjectRegisterPage register= new ProjectRegisterPage();
		PaymentPage payment=new PaymentPage()
		//TeamPage team= new TeamPage();
		
		
		WebElement element = driver.findElement(By.xpath("//h2[text()='Action-Oriented, Measurable Green Performance.']"));
		String headerText = element.getText().toString();
		System.out.println(headerText);
		impliciteWait(5);
		Assert.assertEquals("Action-Oriented, Measurable Green Performance.", headerText);
		
		login.loginToApplication();
		driverwait(2);
		team.ProjectDetailUploadOperatingHour();
		System.out.println("Uploaded successully");
		driverwait(10);
		//login.logoutToApplication();
		
		
		
		register.projectRegistration();
		driverwait(4);
		payment.PaymentToCreditCardApplication();
		driverwait(5);
		team.AddTeamMember();
		driverwait(2);
		login.logoutToApplication();
		driverwait(15);
		
		}
	
		Assert.assertEquals(headerText, "Get started –to arc ");
		Assert.assertEquals("Arc dashboard", driver.getTitle());
		Assert.assertEquals(" dashboard", driver.getTitle());
		
		Assert.assertEquals("Arc dashboard", driver.getTitle());
		ExtentReports report = new ExtentReports(System.getProperty("user.dir")
				+ "\\src\\com\\arc\\extendedReport\\LoginTest.html");
		ExtentTest logger = report.startTest("verify login");
		logger.log(LogStatus.INFO, "Browser is up and running");
		
		logger.log(LogStatus.INFO, "Login Is successfule");
		report.endTest(logger);
		report.flush();
	

	@AfterClass
	public void testDown() {
		closeBrowser();
	}

}
*/