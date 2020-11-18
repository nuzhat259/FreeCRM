package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.DealsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.TasksPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase {
	LoginPage login1;
	HomePage homepage;
	ContactsPage contact;
	TasksPage task;
	DealsPage deals;
	TestUtil testUtil;
	
	public HomePageTest()
	{
	super();
	}
	@BeforeMethod
	public void setUp()
	{
	  initialisation();
	  testUtil=new TestUtil();
	  contact=new ContactsPage();
	  task=new TasksPage();
	  deals=new DealsPage();
	  login1 =new LoginPage();
	  homepage=login1.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void  ValidateHomeTitle()
	{
		String title=homepage.ValidateHomePageTitle();
		Assert.assertEquals(title, "CRMPRO","invalid title, not found");
	}
	@Test(priority=2)
	public void  ValidateUserLabel()
	{
		testUtil.SwitchToFrame();
		boolean flag=homepage.verifyUserLabel();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void ContactLinkTest()
	{
		testUtil.SwitchToFrame();
		contact=homepage.ClickOnContactsLink();
	}
	@Test(priority=4)
	public void TaskLinkTest()
	{
		testUtil.SwitchToFrame();
		task=homepage.ClickOnTasksLink();
	}
	@Test(priority=5)
	public void DealsLinkTest()
	{
		testUtil.SwitchToFrame();
		deals=homepage.ClickOnDealsLink();
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
