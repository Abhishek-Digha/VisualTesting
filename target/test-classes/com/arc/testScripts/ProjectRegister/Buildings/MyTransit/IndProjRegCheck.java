package com.arc.testScripts.ProjectRegister.Buildings.MyTransit;

import org.testng.annotations.Test;

import com.arc.pageLibrary.landingPage.LoginToArc;

import com.arc.pageLibrary.paymentPage.MyBuildings.PaymetCheckPage;
import com.arc.pageLibrary.registrationPage.MyTransit.IndProjectRegisterPage;
import com.arc.testBase.TestBase;

public class IndProjRegCheck {
	public class IndProjectCheck extends TestBase{
		@Test
		public void projectRegisterCC() throws Exception{
		LoginToArc login= new LoginToArc();
		IndProjectRegisterPage pr=new IndProjectRegisterPage();
		PaymetCheckPage paycc=new PaymetCheckPage();
		login.loginToApplication();
		pr.indprojectRegistration();
		paycc.PayemtCheck();
		
		
		}
		


	}
	}
