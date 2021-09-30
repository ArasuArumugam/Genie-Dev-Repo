package com.genie.qa.testcases;

import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.genie.qa.base.TestBase;
import com.genie.qa.pages.HomePage;
import com.genie.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void SetUp() {
		
		TestBase.initialization();
		loginPage= new LoginPage();
		
	}
	
	@Test(priority=2)
	public void LoginPageTitletest()
	{
		
		String title=loginPage.ValidateLoginPageTitle();                                  
		Assert.assertEquals(title,"Genie", "Title Mismatch");
		
	}
	
	@Test(priority=1)
	public void LoginTest() {
		homePage=loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}

}
