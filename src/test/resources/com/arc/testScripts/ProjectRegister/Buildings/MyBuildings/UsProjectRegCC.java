package com.arc.testScripts.ProjectRegister.Buildings.MyBuildings;
import com.arc.pageLibrary.PreCertPage.Buildings.PreCert;
import com.arc.pageLibrary.landingPage.*;
import org.testng.annotations.Test;
import com.arc.pageLibrary.paymentPage.MyBuildings.PaymentCCPage;
import com.arc.pageLibrary.registrationPage.MyBuildings.UsProjectRegisterPage;
import com.arc.testBase.TestBase;

public class UsProjectRegCC extends TestBase{
	@Test
	public void projectRegisterCC() throws Exception{
	LoginToArc login= new LoginToArc();
	UsProjectRegisterPage pr=new UsProjectRegisterPage();
	PaymentCCPage paycc=new PaymentCCPage();
	PreCert precert= new PreCert();
	login.loginToApplication();
	pr.projectRegistration();
	paycc.PaymentCC();
	precert.prerequisties();
	precert.submitforreview();
	paycc.PaymentCC();
	}
	

}
