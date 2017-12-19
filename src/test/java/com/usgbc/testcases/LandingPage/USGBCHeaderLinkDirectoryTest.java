package com.usgbc.testcases.LandingPage;

import java.io.IOException;

import org.testng.annotations.Test;

import com.usgbc.ReusableMethods.ReusableMethodHeaderLinks;
import com.usgbc.driver.BaseClass;

public class USGBCHeaderLinkDirectoryTest extends BaseClass {

	@Test
	public void USGBCHeaderLinkDirectory()throws IOException {
		
		System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
		ReusableMethodHeaderLinks reuse = new ReusableMethodHeaderLinks();

		try {
			
			reuse.headerLinkDirectory();
			
		} catch (Throwable t) {
			System.out.println(t.getLocalizedMessage());
			Error e1 = new Error(t.getMessage());
			e1.setStackTrace(t.getStackTrace());
			throw e1;
		}
	}
	
}
