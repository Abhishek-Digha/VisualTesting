package com.arc.pageLibrary.landingPage;

import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import com.arc.testBase.TestBase;

public class LoginToArc extends TestBase {
	public  void loginToApplication() throws Exception{
		getWebElement("arc.click.login").click();
		WebElement userName = getWebElement("arc.login.username");
		userName.sendKeys(Repository.getProperty("userName"));
		WebElement password = getWebElement("arc.login.password");
		Reporter.log("entering password to the password textbox");
		password.sendKeys(Repository.getProperty("password"));
		Reporter.log("clicking on login button");
		getWebElement("arc.login.loginButton").click();
		
	}
}
