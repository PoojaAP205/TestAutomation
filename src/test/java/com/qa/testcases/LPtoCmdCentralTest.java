package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.AccountTypePage;
import com.qa.pages.CommandCentralPage;
import com.qa.pages.LandingPage;
import com.qa.pages.LoginPage;

public class LPtoCmdCentralTest extends TestBase{

	LoginPage loginPage;
	LandingPage landingPage;
	AccountTypePage accTypePage;
	CommandCentralPage cmdCentralPage;
	
	public LPtoCmdCentralTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization(); 
		loginPage = new LoginPage();
		accTypePage = new AccountTypePage();
		landingPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyLandingPageTitleTest()
	{
		String landingPageTitle = landingPage.verifyLandingPageTitle();
		Assert.assertEquals(landingPageTitle, "HSBC Account Opening", "Landing Page title not match");
	}
	
	@Test(priority=2)
	public void verifyLogonToLabelTest()
	{
		
		Assert.assertTrue(landingPage.validateLogonToLabel());
	}
	
	
	@Test(priority=3)
	public void verifyCommandCentralTest()
	{
		
		cmdCentralPage = landingPage.clickonCommandCentral();
	}
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
