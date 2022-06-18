package com.mypages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	
	private By header=By.className("private-page...title");
	
	public WebElement getHeader() {
		return getElement(header);
	}
	//Page actions
	
	public String getHomePageTitle()
	{
		return getPageTitle();
	}
	
	public String getHomePageHeader()
	{
		return getPageHeader(header);
	}
	
	
}

