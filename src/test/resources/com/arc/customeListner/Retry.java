package com.arc.customeListner;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.arc.testBase.TestBase;
public class Retry extends TestBase implements IRetryAnalyzer {
    private int retryCount = 0;
    private int maxRetryCount = 2;
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
  
        	//Add wait time here and then run below statement
     
        	
        //	driver.get("http://www.stg.arconline.io");
        	//driver.navigate().to(driver.getCurrentUrl());
            System.out.println("Retrying test " + result.getName() + " with status "
                    + getResultStatusName(result.getStatus()) + " for the " + (retryCount+1) + " time(s).");
            retryCount++;
            return true;
        }
        return false;
    }
    
    public String getResultStatusName(int status) {
    	String resultName = null;
    	if(status==1)
    		resultName = "SUCCESS";
    	if(status==2)
    		resultName = "FAILURE";
    	if(status==3)
    		resultName = "SKIP";
		return resultName;
    }
}