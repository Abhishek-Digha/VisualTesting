package com.arc.testScripts.ArcTicket;
import java.util.Iterator;
import java.util.Set;
import com.arc.pageLibrary.Arc451Page.Helper451;
import com.arc.pageLibrary.loginLogoutPage.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.arc.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;

public class ARCPPS451 extends TestBase{
	
        @Test(priority='1')
	    public void VerifyServiceLinKInAddProject()throws Exception{
     
        logger = report.startTest("STG.ARC-451:VERIFY SERVICE AGREEMENT");
        logger.log(LogStatus.INFO,"LOGIN TO APPLICATION");
        LoginLogoutPage login = new LoginLogoutPage();
        driverwait(1);
        login.loginToApplication(); 
        logger.log(LogStatus.INFO, "LOGIN SUCESS");
        
        logger.log(LogStatus.INFO, "REACH SERVICEAGREEMENT");
    	Helper451 help=new Helper451();
    	driverwait(1);
    	help.VerifyServiecAgreement();
    	logger.log(LogStatus.INFO,"REACHED SCUSSESS");
    	
    	logger.log(LogStatus.INFO,"VERIFY SERVICEAGREEMENT LINK");
    	Set<String> set=driver.getWindowHandles();
		Iterator<String> itr=set.iterator();
		String pWd=itr.next();
		String cWd=itr.next();
		driverwait(2);
		driver.switchTo().window(cWd);
		String url=driver.getCurrentUrl();
		System.out.println(url);
		String getURL = driver.getCurrentUrl();
		Assert.assertTrue(getURL.contains(".pdf"));
		logger.log(LogStatus.PASS," VERIFY SERVICE AGREEEMENTS SUCCESSFULLY-TEST PASSED");
		driver.close();
		driver.switchTo().window(pWd); 
		
		
	}
        
        

}
