package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.base.TestBase;

public class UserPage extends TestBase{

	//Initializing the Page Objects
		public UserPage()
		{
			PageFactory.initElements(driver, this);
		}
		
		
		
		//Page Factory
		@FindBy(xpath="//button[@id='usermodal']") 
		WebElement btnAddUser;
		
		@FindBy(xpath="//input[@id='username']") 
		WebElement userName;
		
		@FindBy(xpath="//input[@id='userid']") 
		WebElement userId;
		
		@FindBy(xpath="//input[@id='txtuserMobileNo']") 
		WebElement mobileNo;
		
		@FindBy(xpath="//input[@id='txtuserMailId']") 
		WebElement emailId;
		
		@FindBy(id="branchselect") 
		WebElement selectBranch;
		
		@FindBy(id="roleselect") 
		WebElement selectRole;
		
		@FindBy(id="groupselect") 
		WebElement selectGroup;
		
		@FindBy(id="manager") 
		WebElement selectManager;
		
		@FindBy(xpath="//input[@id='modalSaveBtn']") 
		WebElement btnSave;
		
		@FindBy(xpath="//input[@id='modalClose']") 
		WebElement btnClose;
		
		public void createNewUser(String username, String loginid, String mobileno, String emailid, String branch, String role, String group, String manager)
		{
			btnAddUser.click();
			userName.sendKeys(username);
			userId.sendKeys(loginid);
			mobileNo.sendKeys(mobileno);
			emailId.sendKeys(emailid);
			
			Select selectbranch = new Select(selectBranch);
			selectbranch.selectByVisibleText(branch);
			
			Select selectrole = new Select(selectRole);
			selectrole.selectByVisibleText(role);
			
			Select selectgroup = new Select(selectGroup);
			selectgroup.selectByVisibleText(group);
			
			Select selectmanager = new Select(selectManager);
			selectmanager.selectByVisibleText(manager);
			
			btnSave.click();
			
		}
		
		
}
