package com.spacelabshealthcare.pageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class GoogleHomePage extends BasePage {
	
	
	public GoogleHomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="q")
	public WebElement serarchFiled;
	
	@FindBy(name="btnK")
	public WebElement googleSearchBtn;
	
	
	
	/*
	 * @FindBy(xpath="//*[@id='rso']/div[2]/div/div/div[1]/a") public WebElement
	 * safeNSoundLink;
	 */
	
	
	@FindBy(xpath="//*[@id='rso']/div[2]/div/div/div[1]/a/div/cite")
	public WebElement safeNSoundLink;
	
	

	public void searchText(String text) {
		serarchFiled.sendKeys(text);
		googleSearchBtn.click();
		
	}
	
	
	
	public void assertLinks() {
		String expectedResult="https://www.spacelabshealthcare.com";
		System.out.println("Expected Link: "+expectedResult);
//		String[] result =safeNSoundLink.getText().split(" ");
//		//System.out.println(result);
//		String actualResult=result[2];
		String actualResult=safeNSoundLink.getText();
		System.out.println("Acctual Link Found: "+actualResult);
		Assert.assertEquals(actualResult, expectedResult);
	}
	
	
	
	
	public void searchAndPrintResult(String text) {
		
		
		  List<WebElement> listOfLinks = driver.findElements(By.xpath("//a"));
		    for (WebElement link :listOfLinks ) {

		        if(link.getText().contains(text))
		        {

                   System.out.println(link.getText());
		        }
		    }
		
		
	}
	
	
	
	
	
	
	
	
	
	

}
