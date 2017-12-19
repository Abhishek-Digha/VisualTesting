package com.arc.pageLibrary.Arc451Page;


import org.testng.Reporter;

import com.arc.testBase.TestBase;

public class Helper451 extends TestBase {
	
public void VerifyServiecAgreement() throws Exception {
	
	Reporter.log("Click on Add Project");;
	getWebElement("arc.click.addproject").click();
	Reporter.log("Click on Sevice Agreemnt");
	getWebElement("arc.checksalink").click();
	driverwait(2);
	}
}
