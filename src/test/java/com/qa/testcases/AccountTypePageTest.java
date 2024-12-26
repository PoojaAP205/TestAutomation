package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AccountTypePage;
import com.qa.pages.LandingPage;
import com.qa.pages.LoginPage;

public class AccountTypePageTest extends TestBase {
	
	LoginPage loginPage;
	LandingPage landingPage;
	AccountTypePage accTypePage;
	
	public AccountTypePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization(); 
		accTypePage = new AccountTypePage();
		loginPage = new LoginPage();
		landingPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		accTypePage= landingPage.clickonAccOpeningJourney();
	}
	
	@Test
	public void verifyHsbcLabel()
	{
		Assert.assertTrue(accTypePage.verifyHsbcLabel(), "HsbcLabel is missing on the page");
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
