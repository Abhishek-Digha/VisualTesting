package com.arc.pageLibrary.registrationPage.MyParking;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import com.arc.testBase.TestBase;

public class UsProjectRegisterPage extends TestBase{
	public void projectRegistration() throws Exception
	{	
		
		getWebElement("ClickOnBuilding").click();
		driverwait(1);
		getWebElement("ClickOnMyParking").click();
		driverwait(1);
		
		Reporter.log("Clicking On Add project ");
		getWebElement("arc.click.addproject").click();
	
		Reporter.log("Entering project Name");
		WebElement projectName=getWebElement("arc.project.name");
		projectName.sendKeys(Repository.getProperty("ProjectNameCC"));
		
		
		getWebElement("arc.ratings.building").click();
		driverwait(1);
		getWebElement("selectParking").click();
		driverwait(1);
		WebElement ownerType=getWebElement("arc.OwnertType.textbox");
		ownerType.sendKeys(Repository.getProperty("OwnerType"));
		Reporter.log("Fill Owner Organaization");
	
		WebElement ownerOrg=getWebElement("arc.OwnerOrg.textbox");
		ownerOrg.sendKeys(Repository.getProperty("OwnerOrganization"));
		
		Reporter.log("Fill Owner Email");
		WebElement ownerEmail=getWebElement("arc.OwnerEmail.textbox");
		ownerEmail.sendKeys(Repository.getProperty("OwnerEmail"));
		
		Reporter.log("Click and Select owner country");
		getWebElement("arc.OwnerCountry.click").click();
	
		getWebElement("arc.country.Canada.select").click();
		
	
		Reporter.log("Check Private Checkbox");
		getWebElement("arc.check.private").click();
		
		
		WebElement space= getWebElement("NumberOfPakingSpace");
		space.sendKeys(Repository.getProperty("ParkingSpace"));
		
		WebElement level= getWebElement("levelsOfparking");
		level.sendKeys(Repository.getProperty("parking"));
		
		WebElement data= getWebElement("DataConstructed");
		data.sendKeys(Repository.getProperty("totalDataConstructed"));
		
	
		Reporter.log("Fill Address");
		WebElement address= getWebElement("arc.enter.address");
		address.sendKeys(Repository.getProperty("Address"));
		
		Reporter.log("Fill City Details");
		WebElement city=getWebElement("arc.city.textbox");
		city.sendKeys(Repository.getProperty("City"));
		
		Reporter.log("Click on Country and Select State");
		getWebElement("arc.click.country").click();
		
		getWebElement("arc.select.country.usa").click();
		
		
		getWebElement("arc.click.state.usa").click();;
	
		getWebElement("arc.select.state").click();
		
		Reporter.log("Fill ZipCode");
		WebElement zipcode =getWebElement("arc.zipcode.textbox");
		zipcode.sendKeys(Repository.getProperty("ZipCode"));
		
		
		
		Reporter.log("Click on Check Aggeremet & Next Button");
		getWebElement("arc.agreement.checkbox").click();
		driverwait(2);
		getWebElement("arc.click.next").click();
		driverwait(5);;
		
		
	}

	
}
