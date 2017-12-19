package com.arc.testScripts.login;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.arc.pageLibrary.loginLogoutPage.LoginLogoutPage;
import com.arc.testBase.TestBase;

public class Arc479 extends TestBase {
	
	//WebDriver driver;
	@BeforeClass
	public void setUp() throws IOException {
		init();
	}
	@Test
	public void testArc451()throws Exception{
    	LoginLogoutPage login = new LoginLogoutPage();
    	login.loginToApplication();
    	driverwait(2);
    	driver.findElement(By.xpath("(//input[@id='searchBar'])[2]")).sendKeys("1000123463");
    	System.out.println("Searched");
    	driver.findElement(By.xpath("(//span[text()='1000123463'])[2]")).click();
    	driverwait(2);
    	driver.findElement(By.xpath("//i[@class='fa fa-bar-chart-o pr10']")).click();
    	driverwait(2);
    	driver.findElement(By.xpath("(//a[contains(text(),'Total')])[2]")).click();
    	driverwait(2);
    	WebElement wb=driver.findElement(By.xpath("//th[@class='align-left w50p']/../td[1]"));
    	String str1=wb.getText();
    	double d1=Double.parseDouble(str1);
    	double d2=d1/365.00;
    	WebElement wb2=driver.findElement(By.xpath("(//th[@class='align-left'])[1]/../td[1]"));
    	String str2=wb2.getText();
    	
    	double d3=Double.parseDouble(str2);
    	
    	if(d2==d3)
    		System.out.println("PASS");
    	else
    		System.out.println("FAIL");
    			
    }
    		
    	
    	
	
}
