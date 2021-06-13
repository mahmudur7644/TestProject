package com.spacelabshealthcare.pageObject;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BasePage {
	
	
	public static Properties prop;
	
	public static WebDriver driver;
	
	
	
	
	public BasePage() {
		
		prop=new Properties();
		FileInputStream file;
		try {
			file = new FileInputStream("config.properties");
			prop.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
	
	
	
	
	public static void initializeBrowser() {
		
		 String browser=prop.getProperty("BROWSER");
		
		if (browser.equalsIgnoreCase("chrome")||(browser.equalsIgnoreCase("ch"))) {
			
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
			
			
		}else if (browser.equalsIgnoreCase("firefox")||(browser.equalsIgnoreCase("ff"))) {
			
			System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
			
			driver=new FirefoxDriver();
		}else if (browser.equalsIgnoreCase("internetexplorer")||(browser.equalsIgnoreCase("ie"))) {
			
			System.setProperty("webdriver.ie.driver", "src/test/resources/drivers/IEDriverServer.exe");	
			driver=new InternetExplorerDriver();
			
		}else {
			System.out.println("Sorry Don't reognice the browser input");
		}
		
		//driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
