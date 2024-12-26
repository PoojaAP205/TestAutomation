package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class AccountTypePage extends TestBase {

	
	@FindBy(xpath="//h2[text()='Welcome to HSBC']")
	WebElement hsbcLabel;

	
	public AccountTypePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyHsbcLabel()
	{
		return  hsbcLabel.isDisplayed();
	}
	
	
	
}
