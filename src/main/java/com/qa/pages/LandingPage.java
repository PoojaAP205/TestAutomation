package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LandingPage  extends TestBase{

	@FindBy(xpath="//strong[normalize-space()='Log-on to ?']")
	WebElement logonToLabel;
	
	@FindBy(xpath="//img[@src='/Content/img/user.gif']")
	WebElement accOpenJourney;
	
	@FindBy(xpath="//img[@src='/Content/img/admin.jpg']")
	WebElement commandCentral;
	
	@FindBy(xpath="//img[@title='logout']")
	WebElement logoutBtn;
	
	
	//Initializing the Page Objects
	public LandingPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
		public String verifyLandingPageTitle() {
			return driver.getTitle();
		}

		
		public boolean validateLogonToLabel()
		{
			return logonToLabel.isDisplayed();
		}
		
		public AccountTypePage clickonAccOpeningJourney()
		{
			accOpenJourney.click();
			return new AccountTypePage();
		}
		
		public CommandCentralPage clickonCommandCentral()
		{
			commandCentral.click();
			return new CommandCentralPage();
		}
		
		public void clickonLogoutBtn()
		{
			logoutBtn.click();
			
		}
}
