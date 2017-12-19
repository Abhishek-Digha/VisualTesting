package com.arc.testScripts.login;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.arc.pageLibrary.ARC479Page.Helper479;
import com.arc.pageLibrary.loginLogoutPage.LoginLogoutPage;
import com.arc.testBase.TestBase;

public class ARC480Test extends TestBase{

	@BeforeClass
	public void setUp() throws IOException {
		init();
	}

    @Test
	public void testArc451()throws Exception{
    	LoginLogoutPage login = new LoginLogoutPage();
    	Helper479 help=new Helper479();
    	login.loginToApplication();
    	driverwait(4);
    	help.helptoReachTotalSection();
    	driverwait(4);
    	WebElement yearCarbon=getWebElement("arc.dashbord.anualcarbon");
    	Thread.sleep(2000);
    	String str1=yearCarbon.getText();
    	double d1=Double.parseDouble(str1);
    	double d2=d1/365.00;
    	Thread.sleep(2000);
    	WebElement dailyCarbon=getWebElement("arc.dashbord.dailycarbon");
    	driverwait(3);
    	String str2=dailyCarbon.getText();
    	double d3=Double.parseDouble(str2);
    	
    	
    	if(d2==d3)
    		System.out.println("PASS");
    	else
    		System.out.println("FAIL");    	
		
	}
    @AfterClass
	public void testDown() {
		closeBrowser();
}
}
