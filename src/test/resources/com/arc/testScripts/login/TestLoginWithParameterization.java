package com.arc.testScripts.login;

import java.io.IOException;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.arc.pageLibrary.loginLogoutPage.LoginLogoutPage;
import com.arc.testBase.TestBase;

public class TestLoginWithParameterization extends TestBase{
	
		// I have made method(getDate) in test base class by calling all methods from XLS_Reader class for ease to use.
	@DataProvider
	public  Object[][] Data() throws IOException {
		return getData("Login.xlsx","Login");
	}

	@BeforeClass
	public void initBrowser() throws IOException {
		init();
	}
	
	@Test(dataProvider = "Data")
	public void loginWithParameterization(String TestName, String userName, String password,String runMode) throws Exception {
		
		if(runMode.equals("N")) {
			throw new SkipException("Skipped Test case is");
		}
		
		LoginLogoutPage login = new LoginLogoutPage();
		login.loginToApplication(userName, password);
		driverwait(5);
		login.logoutToApplication();
	}

	@AfterClass
	public void closeBroser() {
		driver.quit();

	}
}
