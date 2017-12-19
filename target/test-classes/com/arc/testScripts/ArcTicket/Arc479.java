package com.arc.testScripts.ArcTicket;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.arc.pageLibrary.ARC479Page.Helper479;
import com.arc.pageLibrary.landingPage.LoginToArc;
import com.arc.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class Arc479 extends TestBase{
    @Test(priority = 1)
	public void testArc451()throws Exception{
    	logger=report.startTest("STG.ARC-479:VERIFY TOTAL DAILY CARBON EMISSIONS");
    	logger.log(LogStatus.INFO,"TEST STARTED");
    	LoginToArc login = new LoginToArc();
    	driverwait(1);
    	login.loginToApplication();
    	logger.log(LogStatus.INFO,"LOGIN PASS");
    	Helper479 help=new Helper479();
    	logger.log(LogStatus.INFO,"CALLED HELPER TO REACAH ANALYTICS TOTAL");
    	driverwait(1);
    	help.helptoReachTotalSection();
    	logger.log(LogStatus.INFO,"REACH  ANALYTICS TOTAL PASS");
    	
    	logger.log(LogStatus.INFO,"VERIFY TOTAL DAILY CARBON EMISSIONS=TOTAL ANNUAL CARBON EMISSIONS/365 STARTED");
    	WebElement yearCarbon=getWebElement("arc.dashbord.anualcarbon");
    	driverwait(1);
    	String str1=yearCarbon.getText();
    	double d1=Double.parseDouble(str1);
    	int i1=(int)d1;
    	int i2=i1/365;
    	driverwait(1);
    	WebElement dailyCarbon=getWebElement("arc.dashbord.dailycarbon");
    	driverwait(1);
    	String str2=dailyCarbon.getText();
    	System.out.println(str2);
    	double d3=Double.parseDouble(str2);
    	int i3=(int)d3;
    	if(i2==i3)
    		logger.log(LogStatus.PASS, "TEST PASSED");
    	else
    		logger.log(LogStatus.FAIL, "TEST FAILED");  
    }
    
    @Test(priority=2)
    public void verifyEnergy() throws Exception
    {
    	logger=report.startTest("STG.ARC-479:VERIFY ENERGY DAILY CARBON EMISSIONS");
    	logger.log(LogStatus.INFO,"TEST STARTED");
		logger.log(LogStatus.INFO,"ENERGY DAILY CARBON EMISSIONS=ENERGY ANNUAL CARBON EMISSIONS/365");
		WebElement anualenergy=getWebElement("arc.dashbord.anualenergy");
		String estr1=anualenergy.getText();
		double ed1=Double.parseDouble(estr1);
		int ei1=(int)ed1;
		logger.log(LogStatus.INFO, "TEST ENERGY DAILY CARBON EMISSIONS STARTED");
		int ei2=ei1/365;
		driverwait(1);
		WebElement dailyenergy=getWebElement("arc.dashbord.dailyenergy");
		String estr2=dailyenergy.getText();
		double ed3=Double.parseDouble(estr2);
		int ei3=(int)ed3;
		if(ei2==ei3)
			logger.log(LogStatus.PASS," TEST PASSED ");
		else
			logger.log(LogStatus.FAIL," TEST FAIL");	
		
        
    }
    
    @Test(priority=3)
    public void verifyTransportation() throws Exception
    {
    	
		logger=report.startTest("STG.ARC-479:VERIFY TRANSPORTATION DAILY CARBON EMISSIONS");
		logger.log(LogStatus.INFO,"TEST STARTED");
		logger.log(LogStatus.INFO," TRANSPORTATION DAILY CARBON EMISSIONS==TRANSPORTATION ANNUAL CARBON EMISSIONS/365");
		WebElement anualtransport=getWebElement("arc.dashbord.anualtransport");
		String tstr1=anualtransport.getText();
		double td1=Double.parseDouble(tstr1);
		logger.log(LogStatus.INFO, "TEST TRANSPORTATION DAILY CARBON EMISSIONS");
		int ti1 = (int) td1;
		int ti2=ti1/365;
		driverwait(1);
		WebElement dailytransport=getWebElement("arc.dashbord.dailytransport");
		String tstr2=dailytransport.getText();
		double td3=Double.parseDouble(tstr2);
		int ti3 = (int) td3;	
		if(ti2==ti3)
			logger.log(LogStatus.PASS,"TEST PASSED");
		else
			logger.log(LogStatus.FAIL," TEST FAILED");	
		
	}

	
  
   
}

