package com.spacelabshealthcare.test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.spacelabshealthcare.pageObject.BasePage;
import com.spacelabshealthcare.pageObject.GoogleHomePage;

public class SpaceLabTestClass extends BasePage {

	GoogleHomePage googleHomePage;

	@BeforeTest
	public void setUpBrowser() {
		BasePage.initializeBrowser();

	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		Thread.sleep(5000);
		driver.close();
	}

	@Test
	public void searchSpaceLab() {

		String URL = prop.getProperty("AppURL");
		driver.get(URL);
		googleHomePage = new GoogleHomePage();
		googleHomePage.searchText("spacelabs safensound");
		googleHomePage.assertLinks();

	}

	@Test
	public void getallThelinksandAsserts() {
		String URL = prop.getProperty("AppURL");
		driver.get(URL);
		googleHomePage = new GoogleHomePage();
		googleHomePage.searchText("spacelabs safensound");
		googleHomePage.searchAndPrintResult("SafeNSound");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
