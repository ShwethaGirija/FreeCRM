package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest()
	{
		super();
		log.info("Inside constructor of LoginPageTest");
	}
	
	
	@BeforeMethod
	public void setup()
	{
		initilaise();
		loginpage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void verifyLoginTitle()
	{
		String actualtitle=loginpage.validatePageTitle();
		String expectedtitle = "Cogmento CRM";
		
		Assert.assertEquals(actualtitle, expectedtitle,"Title Mismatch");
	}
	
	@Test(priority=2)
	public void loginTest()
	{
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	
	
	
}
