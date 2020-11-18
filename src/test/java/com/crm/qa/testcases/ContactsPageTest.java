package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {

	LoginPage login1;
	HomePage homepage;
	ContactsPage conpage;
	TestUtil testUtil;
	String sheetname="Contacts";
	
	public ContactsPageTest()
	{
		super();
	}
	@BeforeMethod
	public void setUp()
	{
		initialisation();
		login1=new LoginPage();
		testUtil=new TestUtil();
		homepage= new HomePage();
		conpage=new ContactsPage();
		homepage=login1.login(prop.getProperty("username"),prop.getProperty("password"));
		testUtil.SwitchToFrame();
		conpage=homepage.ClickOnContactsLink();
	}
	
//	@Test(priority=1)
//	public void ContactLabel()
//	{		
//		boolean flag=conpage.verifyContactsLabel();
//		Assert.assertTrue(flag);
//	}
//	@Test(priority=4)
//	public void clickContacts()
//	{
//		conpage.ClickContactsName("aaa aaa");
//		
//	}
	@DataProvider
	public Object[][] getFreeCRMTestData(){
		Object[][]data=TestUtil.getTestData(sheetname);
		return data;
	}
	
	@Test(priority=3,dataProvider="getFreeCRMTestData" )
	public void saveNewContact(String title,String firstName,String lastName,String company)
	{
		conpage=homepage.clickOnNewContactsLink();
		conpage.CreateNewContact(title,firstName,lastName,company);
	}
	
	@AfterMethod()
	public void tearDown()
	{ 
		//driver.quit();
	}
	
	
	
	
}







