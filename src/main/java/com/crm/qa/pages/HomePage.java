package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//*[contains(text(),'User: Naveen K')]")
	private WebElement UserNameLabel;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	private WebElement DealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	private WebElement ContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	private WebElement NewContactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	private WebElement TasksLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	public String ValidateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean verifyUserLabel()
	{
	 return UserNameLabel.isDisplayed();
	}
	
	public ContactsPage ClickOnContactsLink()
	{
		ContactsLink.click();
		return new ContactsPage();
	}
	
	public ContactsPage clickOnNewContactsLink()
	{
		Actions action=new Actions(driver);
		action.moveToElement(ContactsLink).build().perform();
		NewContactsLink.click();
		return new ContactsPage();
		
	}
	
	public DealsPage ClickOnDealsLink()
	{
		DealsLink.click();
		return new DealsPage();
	}
	public TasksPage ClickOnTasksLink()
	{
		TasksLink.click();
		return new TasksPage();
	}
	
}
