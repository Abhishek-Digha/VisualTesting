package com.arc.testScripts.ProjectRegister.MyCommunities;


import com.arc.pageLibrary.landingPage.*;
import com.arc.pageLibrary.paymentPage.CityCommunity.PaymentCCPage;
import com.arc.pageLibrary.registrationPage.MyCommunities.UsProjectRegisterPage;

import org.testng.annotations.Test;


import com.arc.testBase.TestBase;

public class UsProjectRegCC extends TestBase{
	@Test
	public void projectRegisterCC() throws Exception{
	LoginToArc login= new LoginToArc();
	UsProjectRegisterPage pr=new UsProjectRegisterPage();
	PaymentCCPage paycc=new PaymentCCPage();
	

	login.loginToApplication();
	pr.projectRegistration();;
	paycc.PaymentCC();
	
	
	}
	

}
