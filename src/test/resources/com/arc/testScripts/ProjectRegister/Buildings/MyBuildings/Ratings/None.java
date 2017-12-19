package com.arc.testScripts.ProjectRegister.Buildings.MyBuildings.Ratings;

import org.testng.annotations.Test;

import com.arc.pageLibrary.landingPage.*;
import com.arc.pageLibrary.paymentPage.MyBuildings.PaymetCheckPage;

import com.arc.pageLibrary.registrationPage.MyBuildings.NoneRegister;
import com.arc.testBase.TestBase;

public class None {
	public class IndProjectCheck extends TestBase{
		@Test
		public void projectRegisterCC() throws Exception{
		LoginToArc login= new LoginToArc();
		NoneRegister pr=new NoneRegister();
		PaymetCheckPage check=new PaymetCheckPage();
		login.loginToApplication();
		pr.indprojectRegistration();
		check.PayemtCheck();
		
		
		
		
		
		}
		


	}
	}
