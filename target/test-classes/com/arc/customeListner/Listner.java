package com.arc.customeListner;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.arc.testBase.TestBase;
import com.arc.testUtills.Utills;

public class Listner extends TestBase implements ITestListener, ISuiteListener, IInvokedMethodListener{

	public void onTestStart(ITestResult result) {
		Reporter.log("-----Starting test----"+result.getMethod().getMethodName());
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) {
		if (!result.isSuccess()) {
			String userDirector = System.getProperty("user.dir");
			String customeLocation = "\\src\\com\\arc\\screenShot\\";
			String failureImageFileName = userDirector+customeLocation+new SimpleDateFormat("MM-dd-yyyy_HH-ss").format(new GregorianCalendar().getTime())+"-"+result.getMethod().getMethodName()+ ".png";
			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(scrFile, new File(failureImageFileName));
			} catch (IOException e) {
				e.printStackTrace();
			}
			//String userDirector = System.getProperty("user.dir") + "/";
			Reporter.log("<a href=\"" + failureImageFileName + "\"><img src=\"file:///" + failureImageFileName +"\" alt=\"\"" + "height='100' width='100'/> " + "<br />");
			Reporter.setCurrentTestResult(null);
			
		

		}
		
	}

	
	
	// This belongs to ITestListener and will execute only if any of the main test(@Test) get skipped
	public void onTestSkipped(ITestResult result) {

		printTestResults(result);

	}

	// This is just a piece of shit, ignore this
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	// This is the method which will be executed in case of test pass or fail

	// This will provide the information on the test

	private void printTestResults(ITestResult result) {

		Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);

		if (result.getParameters().length != 0) {

			String params = null;

			for (Object parameter : result.getParameters()) {

				params += parameter.toString() + ",";

			}

			Reporter.log("Test Method had the following parameters : " + params, true);

		}

		String status = null;

		switch (result.getStatus()) {

		case ITestResult.SUCCESS:

			status = "Pass";

			break;

		case ITestResult.FAILURE:

			status = "Failed";

			break;

		case ITestResult.SKIP:

			status = "Skipped";

		}

		Reporter.log("Test Status: " + status, true);

	}

	// This belongs to IInvokedMethodListener and will execute before every method including @Before @After @Test

	public void beforeInvocation(IInvokedMethod result, ITestResult argument) {

		String textMsg = "About to begin executing following method : " + returnMethodName(result.getTestMethod());

		Reporter.log(textMsg, true);

	}

	// This belongs to IInvokedMethodListener and will execute after every method including @Before @After @Test

	public void afterInvocation(IInvokedMethod result, ITestResult argument) {

		String textMsg = "Completed executing following method : " + returnMethodName(result.getTestMethod());

		Reporter.log(textMsg, true);

	}

	// This will return method names to the calling function

	private String returnMethodName(ITestNGMethod method) {

		return method.getRealClass().getSimpleName() + "." + method.getMethodName();

	}

	public void onFinish(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ISuite arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	
}