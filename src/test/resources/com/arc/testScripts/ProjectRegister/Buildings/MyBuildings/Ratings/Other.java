package com.arc.testScripts.ProjectRegister.Buildings.MyBuildings.Ratings;

import org.testng.annotations.Test;

import com.arc.pageLibrary.PreCertPage.Buildings.PreCert;
import com.arc.pageLibrary.landingPage.*;
import com.arc.pageLibrary.paymentPage.MyBuildings.PaymetCheckPage;
import com.arc.pageLibrary.registrationPage.MyBuildings.IndProjectRegisterPage;
import com.arc.pageLibrary.registrationPage.MyBuildings.OtherRegister;
import com.arc.testBase.TestBase;

public class Other {
	public class IndProjectCheck extends TestBase{
		@Test
		public void projectRegisterCC() throws Exception{
		LoginToArc login= new LoginToArc();
		OtherRegister pr=new OtherRegister();
		PaymetCheckPage check=new PaymetCheckPage();
		login.loginToApplication();
		pr.indprojectRegistration();
		check.PayemtCheck();
		
		
		
		
		
		}
		


	}
	}
