package com.qa.testcases;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.TestBase;
import com.qa.pages.CommandCentralPage;
import com.qa.pages.LandingPage;
import com.qa.pages.LoginPage;
import com.qa.pages.UserPage;
import com.qa.util.TestUtil;

public class UserPageTest extends TestBase{

	LoginPage loginPage;
	LandingPage landingPage;
	CommandCentralPage cmdCentralPage;
	UserPage userPage;
	String sheetName="Users";
	
	public UserPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization(); 
		loginPage = new LoginPage();
		landingPage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		cmdCentralPage = landingPage.clickonCommandCentral();
		cmdCentralPage.clickOnMnu_Masters();
		userPage = cmdCentralPage.clickOnMnu_Users();
	}
	
	@DataProvider
	public Object[][] getUserTestData() {
		Object data [][] = TestUtil.getTestData(sheetName);
		return data;
	}
	
	
	@Test(priority=1, dataProvider="getUserTestData")
	public void validateCreateNewUser(String username, String loginid, String mobileno, String emailid, String branch, String role, String group, String manager)
	{ 
	  
		userPage.createNewUser(username, loginid, mobileno, emailid, branch, role, group, manager);
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
