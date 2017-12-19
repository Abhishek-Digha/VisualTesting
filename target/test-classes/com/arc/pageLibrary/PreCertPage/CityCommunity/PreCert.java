package com.arc.pageLibrary.PreCertPage.CityCommunity;

import com.arc.testBase.TestBase;

public class PreCert extends TestBase{
	
	public void submitforreview() throws Exception
	{
		getWebElement("submitforreview").click();
		driverwait(3);
		getWebElement("proceedwithprecert").click();
		driverwait(1);
	}
   public void prerequisties() throws Exception
    {
	   getWebElement("city.prerequisites").click();
	   getWebElement("credit.Committosharingdata").click();
	   driverwait(2);
	   getWebElement("credit.cAffarmation1").click();
	   getWebElement("credit.cAffarmation2").click();
	   driverwait(1);
	   getWebElement("credit.makeCreditEditable").click();
	   getWebElement("clickattempted").click();
	   getWebElement("credit.ReadyforReview").click();
	   getWebElement("credit.Save").click();
	   getWebElement("city.prerequisites").click();
	   driverwait(1);
	   
	   getWebElement("credit.Projectboundary").click();
	   driverwait(2);
	   getWebElement("credit.cAffarmation1").click();
	   driverwait(1);
	   getWebElement("credit.makeCreditEditable1").click(); 
	   driverwait(1);
	   getWebElement("clickattempted").click();
	   getWebElement("credit.ReadyforReview").click();
	   getWebElement("credit.Save").click();
	   getWebElement("building.prerequisites").click();
	   driverwait(1);
	   
	   getWebElement("credit.Governance").click();
	   driverwait(2);
	   getWebElement("credit.cAffarmation1").click();
	   driverwait(1);
	   getWebElement("credit.makeCreditEditable").click();
	   driverwait(1);
	   getWebElement("clickattempted").click();
	   getWebElement("credit.ReadyforReview").click();
	   getWebElement("credit.Save").click();
	   getWebElement("city.prerequisites").click();
	   driverwait(1);
	   
	   getWebElement("credit.Stakeholders").click();
	   driverwait(2);
	   getWebElement("credit.cAffarmation1").click();
	   driverwait(1);
	   getWebElement("credit.makeCreditEditable").click();
	   driverwait(1);
	   getWebElement("clickattempted").click();
	   getWebElement("credit.ReadyforReview").click();
	   getWebElement("credit.Save").click();
	   getWebElement("building.prerequisites").click();
	   driverwait(1);
	   
	   getWebElement("credit.Meeting").click();
	   driverwait(2);
	   getWebElement("credit.cAffarmation1").click();
	   driverwait(1);
	   getWebElement("credit.makeCreditEditable").click();
	   driverwait(1);
	   getWebElement("clickattempted").click();
	   getWebElement("credit.ReadyforReview").click();
	   getWebElement("credit.Save").click();
	   getWebElement("building.prerequisites").click();
	   driverwait(1);
	   
	   getWebElement("credit.Roadmap").click();
	   driverwait(2);
	   getWebElement("credit.cAffarmation1").click();
	   driverwait(1);
	   getWebElement("credit.makeCreditEditable").click();
	   driverwait(1);
	   getWebElement("clickattempted").click();
	   getWebElement("credit.ReadyforReview").click();
	   getWebElement("credit.Save").click();
	   getWebElement("building.prerequisites").click();
	   driverwait(1);
	   
	   
	   
	   
	   
    }
}