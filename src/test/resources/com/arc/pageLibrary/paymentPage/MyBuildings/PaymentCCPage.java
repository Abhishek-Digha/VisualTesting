package com.arc.pageLibrary.paymentPage.MyBuildings;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.arc.testBase.TestBase;

public class PaymentCCPage extends TestBase {
	public void PaymentCC() throws Exception{
		Reporter.log("Fill Credit name ");;
		WebElement nameoncard=getWebElement("arc.creditcard.name");
		nameoncard.sendKeys(Repository.getProperty("NameonCard"));
	
		Reporter.log("Credit Card Number Fill");
		WebElement creditcardnumber=getWebElement("arc.creditcard.number");
		creditcardnumber.sendKeys(Repository.getProperty("CreditCardNumber"));
	
		Reporter.log("Fill Expiration Date");
		WebElement expiration=getWebElement("arc.creditcard.expdate");
		expiration.sendKeys(Repository.getProperty("ExpirationDate"));
		
		Reporter.log("Fill CVV");
		WebElement cvv=getWebElement("arc.creditcard.cvv");
		cvv.sendKeys(Repository.getProperty("CVV"));
		
		Reporter.log("Fill Bill to Party Name ");
		WebElement billtopartyname=getWebElement("arc.creditcard.billtopartyname");
		billtopartyname.sendKeys(Repository.getProperty("Billtopartyname"));
		
		Reporter.log("Fill Bill to Party Eamil ");
		WebElement billtopartyeamil=getWebElement("arc.creditcard.email");
		billtopartyeamil.sendKeys(Repository.getProperty("Billtopartyemail"));
		
		Reporter.log("Fill Address1");
		WebElement address1=getWebElement("arc.creditcard.address1");
		address1.sendKeys(Repository.getProperty("Address1"));
	
		
		Reporter.log("Fill Address2");
		WebElement address2=getWebElement("arc.creditcard.address2");
		address2.sendKeys(Repository.getProperty("Address2"));
		
		
		Reporter.log("Fill City");
		WebElement city=getWebElement("arc.creditcard.city");
		city.sendKeys(Repository.getProperty("City"));
		
		Reporter.log("Country click and select & state");
		getWebElement("arc.creditcard.countryclick").click();
		
		getWebElement("arc.creditcard.usaselect").click();
		
		getWebElement("arc.creditcard.clickstate").click();
		
		getWebElement("arc.creditcard.california").click();
		
		Reporter.log("Fill ZipCode");
		WebElement zipcode=getWebElement("arc.creditcard.zipcode");
		zipcode.sendKeys(Repository.getProperty("ZipCode"));
		
		Reporter.log("Click on Next");
		getWebElement("arc.creditcard.clicknext").click();
		driverwait(16);
		getWebElement("arc.creditcard.getstared").click();
		driverwait(5);
	}

}
