package com.crm.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;

public class HomePageTest extends TestBase {

	static HomePage homepage;
	static LoginPage loginpage;
	static ContactsPage contactspage;
	static DealPage dealspage;
	static TasksPage taskspage;
	
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup()
	{
		initilaise();
		homepage = new HomePage();
		loginpage= new LoginPage();
		contactspage=new ContactsPage();
		
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=0)
	public void TestverifyHomepageTitle()
	{
		String actual_title = homepage.verifyHomepageTitle();
		String expected_title="Cogmento CRM";
		
		Assert.assertEquals(actual_title, expected_title,"Homepage Title Mismatch");
	}
	
	@Test(priority=1)
	public void TestVerifyLoginName()
	{
		Assert.assertTrue(homepage.verifyLoginName());
	}
	
	@Test(priority=2)
	public void TestClickonContacts() throws InterruptedException
	{
	  contactspage=	homepage.clickOnContactsLink();
	  Thread.sleep(2000);
	  Assert.assertTrue(contactspage.verifyContactsHeader());
	}
	
	@Test(priority=3)
	public void TestClickonDeals()
	{
		dealspage = homepage.clickOnDealsLink();
	}
	
	@Test(priority=4)
	public void TestClickonTasks()
	{
		taskspage=homepage.clickOnTasksLink();
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
