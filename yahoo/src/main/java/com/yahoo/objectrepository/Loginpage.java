package com.yahoo.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage 

{

	
	@FindBy(xpath="//input[@id='login-username']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='login-signin']")
	private WebElement nextbutton;
	
	public Loginpage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}
	
	public WebElement getusername()
	{
		return username;
	}
	public WebElement getnextbutton()
	{
		return nextbutton;
	}
}
