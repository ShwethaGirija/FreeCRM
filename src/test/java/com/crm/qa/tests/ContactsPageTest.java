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
import com.util.testdata.ReadExcel;

public class ContactsPageTest extends TestBase{

	static HomePage homepage;
	static LoginPage loginpage;
	static ContactsPage contactspage;
	static DealPage dealspage;
	static TasksPage taskspage;
	
	public ContactsPageTest()
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
		contactspage=homepage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void TestVerifyContactsHeader()
	{
		Assert.assertTrue(contactspage.verifyContactsHeader());
	}
	
	@Test(priority=2)
	public void clickonTomPterCheckbox()
	{
		Assert.assertTrue(contactspage.clickonTomPterCheckbox());
	}
	
	@Test(priority=3,dataProvider="testdata", dataProviderClass = ReadExcel.class)
	public void addNewContact(String[] s) throws InterruptedException
	{
		contactspage.clickonNewContact();
		contactspage.createNewContact(s[0],s[1]);
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
