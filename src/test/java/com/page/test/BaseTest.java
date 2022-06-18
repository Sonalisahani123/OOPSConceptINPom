package com.page.test;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.mypages.BasePage;
import com.mypages.Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	  WebDriver driver;
	  public Page page;
	  
	  @BeforeMethod
	  @Parameters({"browser"})
	  public void setUpTest(String browser)
	  {
		  if(browser.equals("chrome"))
		  {
			  WebDriverManager.chromedriver().setup();
			  driver=new ChromeDriver();
			  
		  }else if (browser.equals("ff"))
		  {
			  WebDriverManager.firefoxdriver().setup();
			  driver=new FirefoxDriver();
			  
				 
		  }else {
			  
			  System.out.println("no browser defined in xml");
		  }
		  
		  driver.get("https://app.hubspot.com/login");
		  try {
			  Thread.sleep(2000);
			  
		  }catch(InterruptedException e)
		  {
			  e.printStackTrace();
		  }
		  //whatever page we are using need to initialize here by createing the page class object
		  //we have to  pass the  driver details to all webpage
		  page= new BasePage(driver);
		  
	  }
	  
	  @AfterMethod
	  public void tearDown()
	  {
		  driver.quit();
	  }
	
	
	
	

}
