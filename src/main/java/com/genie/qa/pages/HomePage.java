package com.genie.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genie.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//button[@id='__BVID__21__BV_toggle_']")
	WebElement AddTask;
	
	@FindBy(xpath="//h6[contains(text(),'Mutharasan Arumugam')]")
	WebElement LoggedUser;
	
	@FindBy(xpath="//body/div[@id='app']/div[1]/div[1]/div[1]/ul[1]/div[1]/li[7]/div[1]/a[1]")
	WebElement Admin;
	
	@FindBy(xpath="//a[text()='User ']")
	WebElement User;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String VerifyHomePageTitle()
	{
		String s=driver.getTitle();
		return s;
	}
	
	public boolean VerifyLoggedUser()
	{
		boolean b=LoggedUser.isDisplayed();
		return b;
	}
	
	public void ExpandAdminMenu()
	{
		Admin.click();
	}
	public UserPage ClickOnUserLink()
	{
		User.click();
		return new UserPage();
	}
	

}
