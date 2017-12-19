package com.arc.testScripts.ProjectRegister.Buildings.MyBuildings;

import org.testng.annotations.Test;

import com.arc.pageLibrary.PreCertPage.Buildings.PreCert;
import com.arc.pageLibrary.landingPage.*;
import com.arc.pageLibrary.paymentPage.MyBuildings.PaymetCheckPage;
import com.arc.pageLibrary.registrationPage.MyBuildings.IndProjectRegisterPage;
import com.arc.testBase.TestBase;

public class IndProjRegCheck {
	public class IndProjectCheck extends TestBase{
		@Test
		public void projectRegisterCC() throws Exception{
		LoginToArc login= new LoginToArc();
		IndProjectRegisterPage pr=new IndProjectRegisterPage();
		PaymetCheckPage check=new PaymetCheckPage();
		PreCert precert= new PreCert();
		login.loginToApplication();
		pr.indprojectRegistration();
		check.PayemtCheck();
		precert.prerequisties();
		
		
		
		
		}
		


	}
	}
