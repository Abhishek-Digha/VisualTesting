package com.arc.pageLibrary.paymentPage.MyBuildings;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.arc.testBase.TestBase;

public class PaymetCheckPage extends TestBase {
	
	public void PayemtCheck() throws Exception{
	Reporter.log("Select Indian project");

	WebElement billparty = getWebElement("arc.check.billtopartyname");
	billparty.sendKeys(Repository.getProperty("Billtopartyname"));
	
	WebElement billemail = getWebElement("arc.check.email");
	billemail.sendKeys(Repository.getProperty("Billtopartyemail"));
	
	WebElement address1 = getWebElement("arc.check.address1");
	address1.sendKeys(Repository.getProperty("Address1"));
	
	WebElement address2 = getWebElement("arc.check.address2");
	address2.sendKeys(Repository.getProperty("Address2"));
	
	WebElement city = getWebElement("arc.check.city");
	city.sendKeys(Repository.getProperty("City"));
	
	getWebElement("arc.check.countryclick").click();
	
	getWebElement("arc.check.usaselect").click();
	getWebElement("arc.check.clickstate").click();
	getWebElement("arc.check.california").click();
	
	WebElement zip = getWebElement("arc.check.zipcode");
	zip.sendKeys(Repository.getProperty("ZipCode"));
	
	getWebElement("arc.check.clicknext").click();
	driverwait(17);
	getWebElement("arc.creditcard.getstared").click();
	driverwait(3);
	}
}