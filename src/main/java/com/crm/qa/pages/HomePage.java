package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//span[@class='user-display' and contains(text(),'Shwetha')]")
	WebElement LoginName;
	
	
	@FindBy(xpath="//span[@class='item-text' and contains(text(),'Contacts')]/parent::a")
	WebElement contactsLink;
	
	@FindBy(xpath="//span[@class='item-text' and contains(text(),'Deals')]/parent::a")
	WebElement dealsLink;
	
	@FindBy(xpath="//span[@class='item-text' and contains(text(),'Tasks')]/parent::a")
	WebElement tasksLink;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomepageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyLoginName()
	{
		return LoginName.isDisplayed();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	
	public DealPage clickOnDealsLink()
	{
		dealsLink.click();
		return new DealPage();
	}
	
	public TasksPage clickOnTasksLink()
	{
		tasksLink.click();
		return new TasksPage();
	}

}
