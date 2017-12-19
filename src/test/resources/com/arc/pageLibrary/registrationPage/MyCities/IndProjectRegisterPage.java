package com.arc.pageLibrary.registrationPage.MyCities;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import com.arc.testBase.TestBase;

public class IndProjectRegisterPage extends TestBase{
	public void indprojectRegistration() throws Exception
	{	
		getWebElement("ClickOnCity").click();
		Reporter.log("Clicking On Add project ");
		getWebElement("arc.click.addproject").click();
		
		Reporter.log("Entering project Name");
		WebElement projectName=getWebElement("arc.project.name");
		projectName.sendKeys(Repository.getProperty("projectNameCheck"));
		
		Reporter.log("Select SI");
		getWebElement("arc.unitType.si").click();
		
		getWebElement("arc.ratings.city").click();
		getWebElement("arc.projecttype.leed.city").click();
		
		Reporter.log("Fill Owner Type");
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
		Reporter.log("Fill Area");
		
		WebElement area=getWebElement("arc.area");
		area.sendKeys(Repository.getProperty("Area"));

		Reporter.log("Check Private Checkbox");
		getWebElement("arc.check.private").click();
		
		Reporter.log("Fill Population");
		WebElement population= getWebElement("arc.text.population");
		population.sendKeys(Repository.getProperty("Population"));
	
		Reporter.log("Fill Address");
		WebElement address= getWebElement("arc.enter.address");
		address.sendKeys(Repository.getProperty("Address"));
	
		Reporter.log("Fill City Details");
		WebElement city=getWebElement("arc.city.textbox");
		city.sendKeys(Repository.getProperty("City"));
		
		Reporter.log("Click on Country and Select State");
		getWebElement("arc.click.country").click();
	
		getWebElement("arc.select.country.india").click();
	
		getWebElement("arc.click.state.india").click();;
		
		getWebElement("arc.select.state").click();
		
		Reporter.log("Fill ZipCode");
		WebElement zipcode =getWebElement("arc.zipcode.textbox");
		zipcode.sendKeys(Repository.getProperty("IndZipcode"));
		
		
		
		Reporter.log("Click on Check Aggeremet & Next Button");
		getWebElement("arc.agreement.checkbox").click();

		getWebElement("arc.click.next").click();
		driverwait(10);
		
		
	}

	
}
