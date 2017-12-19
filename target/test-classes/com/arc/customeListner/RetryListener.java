package com.arc.customeListner;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import com.arc.testBase.TestBase;

public class RetryListener extends TestBase implements IAnnotationTransformer  {
	public void transform(ITestAnnotation testannotation, Class testClass,
			Constructor testConstructor, Method testMethod)	{
		IRetryAnalyzer retry = testannotation.getRetryAnalyzer();

		if (retry == null)	{
			testannotation.setRetryAnalyzer(Retry.class);
			//driver.get("http://www.stg.arconline.io");
			//driver.close();
			
		}

	}
}