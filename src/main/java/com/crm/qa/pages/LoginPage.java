package com.crm.qa.pages;

import org.apache.log4j.LogManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;


public class LoginPage extends TestBase{

	public static org.apache.log4j.Logger log = LogManager.getLogger(LoginPage.class);
	//pagefactory or OR
	
	@FindBy(name="email")
	WebElement uname;
	
	@FindBy(name="password")
	WebElement pwd;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginbtn;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpbtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver,this);
	}
	
	public String validatePageTitle()
	{
		log.info("Inside Login Page validate title");
		return driver.getTitle();
	}
	
	public HomePage login(String pUsername, String pPassword)
	{
		uname.sendKeys(pUsername);
		pwd.sendKeys(pPassword);
		loginbtn.click();
		
		return new HomePage();
	}
	
}
