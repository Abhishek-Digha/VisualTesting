package com.usgbc.ReusableMethods;

import com.usgbc.driver.CommonMethod;

import ru.yandex.qatools.ashot.Screenshot;

public class ReusableMethodHeaderLinks extends CommonMethod{

		
	public  void LandingPageUSGBC() throws Exception {
		
		CommonMethod.hideDisplayedElement("newsfeed");
		//CommonMethod.waitJS();
		Thread.sleep(2000);

        //Take ScreenShot with AShot
        Screenshot landingScreenShot = takeScreenshot();

        //Write actual screenshot to the actual screenshot path
        writeScreenshotToFolder(landingScreenShot);

        //Do image comparison
        doComparison(landingScreenShot);
		
	}
	
	
	public  void headerLinkLeed() throws Exception{
		
		CommonMethod.click("leedLink");
		//CommonMethod.waitJS();
		Thread.sleep(2000);

        //Take ScreenShot with AShot
        Screenshot leedScreenShot = takeScreenshot();

        //Write actual screenshot to the actual screenshot path
        writeScreenshotToFolder(leedScreenShot);

        //Do image comparison
        doComparison(leedScreenShot);
	}
		
	public  void headerLinkCredentials() throws Exception{
		
		CommonMethod.click("credentialsLink");
		//CommonMethod.waitJS();
		Thread.sleep(2000);

        //Take ScreenShot with AShot
        Screenshot credentialsScreenShot = takeScreenshot();

        //Write actual screenshot to the actual screenshot path
        writeScreenshotToFolder(credentialsScreenShot);

        //Do image comparison
        doComparison(credentialsScreenShot);
	}
	
	
	
	public  void headerLinkJoin() throws Exception{
		
		CommonMethod.click("joinLink");
		//CommonMethod.waitJS();
		Thread.sleep(2000);

        //Take ScreenShot with AShot
        Screenshot joinScreenShot = takeScreenshot();

        //Write actual screenshot to the actual screenshot path
        writeScreenshotToFolder(joinScreenShot);

        //Do image comparison
        doComparison(joinScreenShot);
	}
	
	public  void headerLinkStore() throws Exception{
		
		CommonMethod.click("storeLink");
		//CommonMethod.waitJS();
		Thread.sleep(2000);

        //Take ScreenShot with AShot
        Screenshot storeScreenShot = takeScreenshot();

        //Write actual screenshot to the actual screenshot path
        writeScreenshotToFolder(storeScreenShot);

        //Do image comparison
        doComparison(storeScreenShot);
	}
	
	public void headerLinkResources() throws Exception{
		
		CommonMethod.click("resourcesLink");
		//CommonMethod.waitJS();
		Thread.sleep(2000);

        //Take ScreenShot with AShot
        Screenshot resourcesScreenShot = takeScreenshot();

        //Write actual screenshot to the actual screenshot path
        writeScreenshotToFolder(resourcesScreenShot);

        //Do image comparison
        doComparison(resourcesScreenShot);
	}
	
	public  void headerLinkEducation() throws Exception{
		
		CommonMethod.click("educationLink");
		//CommonMethod.waitJS();
		Thread.sleep(2000);

        //Take ScreenShot with AShot
        Screenshot educationScreenShot = takeScreenshot();

        //Write actual screenshot to the actual screenshot path
        writeScreenshotToFolder(educationScreenShot);

        //Do image comparison
        doComparison(educationScreenShot);
	}
	
	
	public void headerLinkDirectory() throws Exception{
		
		CommonMethod.click("directoryLink");
		//CommonMethod.waitJS();
		Thread.sleep(2000);

        //Take ScreenShot with AShot
        Screenshot directoryScreenShot = takeScreenshot();

        //Write actual screenshot to the actual screenshot path
        writeScreenshotToFolder(directoryScreenShot);

        //Do image comparison
        doComparison(directoryScreenShot);
	}
	
	
	public void headerLinkArticles() throws Exception{
		
		CommonMethod.click("articleLink");
		//CommonMethod.waitJS();
		Thread.sleep(2000);

        //Take ScreenShot with AShot
        Screenshot articlesScreenShot = takeScreenshot();

        //Write actual screenshot to the actual screenshot path
        writeScreenshotToFolder(articlesScreenShot);

        //Do image comparison
        doComparison(articlesScreenShot);
	}
	
	public void headerLinkAccounts() throws Exception{
		
		CommonMethod.click("accountLink");
		//CommonMethod.waitJS();
		Thread.sleep(2000);

        //Take ScreenShot with AShot
        Screenshot accountsScreenShot = takeScreenshot();

        //Write actual screenshot to the actual screenshot path
        writeScreenshotToFolder(accountsScreenShot);

        //Do image comparison
        doComparison(accountsScreenShot);
	}
	
	
	
	
}
