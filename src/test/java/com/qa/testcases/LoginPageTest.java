package com.qa.testcases;

/*************************************** PURPOSE **********************************/
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.LandingPage;
import com.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage loginPage;
	LandingPage landingPage;
	
	public LoginPageTest() {
		super();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		loginPage = new LoginPage();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "HSBC Account Opening");
	}
	
	@Test(priority=2)
	public void LogoTest()
	{
		boolean flag = loginPage.validateLogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void loginTest()
	{
		landingPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
