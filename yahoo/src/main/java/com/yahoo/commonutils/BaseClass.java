package com.yahoo.commonutils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.yahoo.objectrepository.Loginpage;
import com.yahoo.objectrepository.PasswordPage;

public class BaseClass
{
	
	public static WebDriver driver;
	
	
@BeforeClass
public void configBeforeclas()
{
	System.out.println("......///..launch the browser......///");
	 driver = new ChromeDriver();
	 driver.get("https://login.yahoo.com");	
}
	
@BeforeMethod

public void configBeforeMeth() throws InterruptedException
{
	System.out.println(".......login to applicatyion.....");
	Loginpage log =new Loginpage(driver);
	log.getusername().sendKeys("raghavendrat290296@yahoo.com");
	log.getnextbutton().click();
	PasswordPage pwd = new PasswordPage(driver);
	WebElement pwdelement = pwd.getpassword();
	WebDriverWait wait = new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='login-passwd']")));
	
	pwdelement.sendKeys("9148617954a");
	pwd.getnextbuttonPwdpage().click();
	
	
}
@AfterMethod
public void configaftermet()
{
	 WebDriverWait wai = new WebDriverWait(driver, 15);
	 wai.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='header-profile-button']")));
	 WebElement element = driver.findElement(By.xpath("//button[@id='header-profile-button']"));
	 Actions act = new Actions(driver);
	 act.moveToElement(element).perform();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.findElement(By.xpath("//a[@id='profile-signout-link']")).click();
}
}
