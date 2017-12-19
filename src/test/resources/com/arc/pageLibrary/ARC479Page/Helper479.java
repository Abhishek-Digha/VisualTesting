package com.arc.pageLibrary.ARC479Page;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.arc.testBase.TestBase;

public class Helper479 extends TestBase {
	public void helptoReachTotalSection()throws Exception 
	{
		Reporter.log("Search");
		WebElement search=getWebElement("arc.dashbord.search");
		search.sendKeys(Repository.getProperty("ProjectId"));
		driverwait(1);	
		Reporter.log("Click search on Selected Project ");
		getWebElement("arc.dashbord.project").click();
		driverwait(1);
		getWebElement("arc.dashbord.analytics").click();
		driverwait(1);
		getWebElement("arc.dashbord.toatl").click();
		driverwait(1);
		
		
	}
	

}
