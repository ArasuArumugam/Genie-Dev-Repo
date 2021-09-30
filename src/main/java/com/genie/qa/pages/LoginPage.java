package com.genie.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.genie.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	@FindBy(id="email")
	WebElement UserEmail;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(id="btnLogin")
	WebElement LoginButton;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement SignUp;
	
	public LoginPage() {
		
		PageFactory.initElements(driver, this);
	}
	
	public String ValidateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage Login(String UserName, String Pswd)
	{
		UserEmail.sendKeys(UserName);
		Password.sendKeys(Pswd);
		LoginButton.click();
		
		return new HomePage();
	}
	

}
