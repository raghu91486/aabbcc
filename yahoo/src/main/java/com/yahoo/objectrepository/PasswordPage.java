package com.yahoo.objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordPage 
{

	@FindBy(xpath="//input[@id='login-passwd']")
	private WebElement passwordtextf;
	
	@FindBy(xpath="//button[@id='login-signin']")
	private WebElement nextbutton;
	

	public PasswordPage(WebDriver driver)
	{
	PageFactory.initElements(driver, this);	
	}
	
	
	public WebElement getpassword()
	{
		return passwordtextf;
	}
	
	public WebElement getnextbuttonPwdpage()
	{
		return nextbutton;
	}
}