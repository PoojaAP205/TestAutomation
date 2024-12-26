package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class CommandCentralPage extends TestBase {

	public CommandCentralPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Page Factory
		@FindBy(xpath="//p[normalize-space()='Masters']") 
		WebElement mnu_Masters;
		
	
		@FindBy(xpath="//p[normalize-space()='User']") 
		WebElement mnu_Users;
		
		
		public void clickOnMnu_Masters()
		{
			System.out.println("mnu_Masters.click();");
			mnu_Masters.click();
		}
		
		public UserPage clickOnMnu_Users()
		{
			mnu_Users.click();
			return new UserPage();
		}
		
}
