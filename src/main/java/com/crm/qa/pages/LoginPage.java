package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

  @FindBy(name="username")
  private WebElement username;
  
  @FindBy(name="password")
  private WebElement password;
  
  @FindBy(xpath="//input[@type='submit']")
  private WebElement loginbtn;
  
  @FindBy(xpath="//button[contains(text(),'Sign Up')]")
  private WebElement signbtn;
  
  @FindBy(xpath="//img[@class='img-responsive']")
  private WebElement crmlogo;
  
  public LoginPage(){
	  PageFactory.initElements(driver,this);
	  }
  
  public String validateloginpageTitle()
  {
	  return driver.getTitle();
  }
  public boolean validateLogo()
  {
	  return crmlogo.isDisplayed();
  }
  
  
  public HomePage login(String un,String pwd)
  {
	  username.sendKeys(un);
	  password.sendKeys(pwd);
	  loginbtn.submit();
	   return new HomePage();
	  
  }
  
  
}
