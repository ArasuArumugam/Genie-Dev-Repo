package com.genie.qa.testcases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.genie.qa.base.TestBase;
import com.genie.qa.pages.HomePage;
import com.genie.qa.pages.LoginPage;

public class HomePageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage homePage;
	
	
	public HomePageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void SetUp() {
		
		TestBase.initialization();
		loginPage= new LoginPage();
		homePage=loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test
	public void ValidateHomePageTitle()
	{
		String Actual=homePage.VerifyHomePageTitle();
		Assert.assertEquals(Actual, "Home - Genie", "Title Mismatch");
	}
	
	@Test
	public void ValidateLoggedUser()
	{
		boolean b=homePage.VerifyLoggedUser();
		Assert.assertTrue(b);
	}
	
	@Test
	public void ClickOnUserLink()
	{
		homePage.ExpandAdminMenu();
		homePage.ClickOnUserLink();
	}
	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}

}
