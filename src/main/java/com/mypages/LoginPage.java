package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	//page locators by using By locator(its very simple and light waight)
	
	//2.declare with private variable to achive encapsulation, it will be encapsulated and won't be avialble to out side.
	private By emailId=By.id("username");
	private By password=By.id("password");
	private By loginbtn=By.id("Log in");
	private By header=By.xpath("//i18n-string[@data-key='login.signupLink.text']");
	//to access the private variable by using public methods  this is 3.Encapsulation
	
	public WebElement getEmailId() {
		return getElement(emailId);
	}
	
	public WebElement  getPassword() {
		return getElement(password);
	}
	
	public WebElement getLoginbtn() {
		return getElement(loginbtn);
	}
	
	public WebElement getHeader() {
		return getElement(header);
	}
	
	
	public String getLoginPageTitle()
	{
		return getPageTitle();
	}
	
	public void getLoginPageHeader()
	{
		getPageHeader(header);
	}
	
	
	/* login with username and password */
	public HomePage doLogin(String username,String password)
	{
		getEmailId().sendKeys(username);
		getPassword().sendKeys(password);
		getLoginbtn().click();
		
		return getInstance(HomePage.class);
	}
	
	/* method overloading cocept ,we can test it  like negative scenario */
	
	public void doLogin()
	{
		getEmailId().sendKeys("");
		getPassword().sendKeys("");
		getLoginbtn().click();
		
		
	}
	public void doLogin(String userCred)
	{
		if(userCred.contains("username"))
		{
			getEmailId().sendKeys(userCred.split(":")[1].trim());
		}else if(userCred.contains("password")){
			
			getPassword().sendKeys(userCred.split(":")[1].trim());
		}
		getLoginbtn().click();
		
		
	}
	
	
	

}
