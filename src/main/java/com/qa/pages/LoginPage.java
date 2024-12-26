package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LoginPage extends TestBase {

	//Page Factory
	@FindBy(name="UserName") 
	WebElement username;

	@FindBy(name="Password") 
	WebElement password;

	@FindBy(id="btnlogin") 
	WebElement loginBtn;

	@FindBy(xpath="//img[@src='/Content/img/logo.png']") 
	WebElement logo;

	//Initializing the Page Objects
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateLogo()
	{
		return logo.isDisplayed();
	}

	public LandingPage login(String un, String pwd)
	{
		username.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new LandingPage();
	}

}
