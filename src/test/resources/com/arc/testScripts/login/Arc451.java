package com.arc.testScripts.login;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import com.arc.pageLibrary.Arc451Page.Helper451;
import com.arc.pageLibrary.loginLogoutPage.*;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.arc.testBase.TestBase;

public class Arc451 extends TestBase{
	@BeforeClass
	public void setUp() throws IOException {
		init();
	}

        @Test(priority='1')
	    public void VerifyServiceLinKInAddProject()throws Exception{
    	LoginLogoutPage login = new LoginLogoutPage();
    	Helper451 help=new Helper451();
    	login.loginToApplication();
    	driverwait(2);
    	help.VerifyServiecAgreement();
    	driverwait(1);
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
		System.out.println("PASS");
		driverwait(1);
		driver.close();
		driver.switchTo().window(pWd); 
		
	}
        @AfterClass
    	public void testDown() {
    		closeBrowser(); 
}
}
