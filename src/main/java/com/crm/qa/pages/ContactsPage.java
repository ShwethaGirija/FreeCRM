package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contactsHeader;
	
	@FindBy(xpath="//a[text()='Tom Peter']/parent::td/preceding-sibling::td /div/input")
	WebElement tompeter;
	
	@FindBy(xpath="//button[contains(text(),'Create')]/parent::a")
	WebElement newcontactLink;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstname;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastname;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement savebtn;
	
	public ContactsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyContactsHeader()
	{
		return contactsHeader.isDisplayed();
	}

	public boolean clickonTomPterCheckbox() 
	{
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		tompeter.click();
		return tompeter.isSelected();
	}
	
	public void clickonNewContact()
	{
		newcontactLink.click();
	}
	
	public void createNewContact(String pfirstname,String plastname) throws InterruptedException
	{
		firstname.sendKeys(pfirstname);
		lastname.sendKeys(plastname);
		savebtn.click();
		Thread.sleep(2000);
	}
}
