package com.arc.pageLibrary.teamPage;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.arc.testBase.TestBase;

public class TeamPage extends TestBase {
	public void AddTeamMember()throws Exception 
	{
		Reporter.log("Clicking On Manage ");
		getWebElement("arc.manage.click").click();
		Reporter.log("Clicking on Manage Section");
		getWebElement("arc.team.click").click();
		Reporter.log("Click on Arc Team Member");
		driverwait(2);
		WebElement addemail=getWebElement("arc.team.addemailmember");
		addemail.sendKeys(Repository.getProperty("Addateammember"));
		driverwait(6);
		getWebElement("arc.team.addteammember.click").click();
		driverwait(18);
	}
	public void ProjectDetailUploadOperatingHour()throws Exception
	{
		getWebElement("arc.select.project").click();
		driverwait(2);
		getWebElement("arc.manage.click").click();
		driverwait(2);
		getWebElement("arc.project.click").click();
		driverwait(2);
		getWebElement("arc.project.operatinghour.click").click();;
		driverwait(2);
		getWebElement("arc.project.operatinghour.fileupload.click").click();
		driverwait(5);
		Runtime.getRuntime().exec("C:\\Users\\Group10\\Desktop\\excelupload.exe");
		driverwait(10);
		
		/*WebElement filepath=getWebElement("arc.project.operatinghour.fileupload.click");
		filepath.sendKeys(Repository.getProperty("arc.data.temp.send"));*/
		
	}

}
