package com.genie.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.genie.qa.base.TestBase;
import com.genie.qa.pages.HomePage;
import com.genie.qa.pages.LoginPage;
import com.genie.qa.pages.UserPage;
import com.genie.qa.util.TestUtil;

public class UserPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	UserPage userPage;
	
	String Sheetname="Users";
	
	
	public UserPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void SetUp() {
		
		TestBase.initialization();
		loginPage= new LoginPage();
		homePage= new HomePage();
		userPage=new UserPage();
		homePage=loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
		
	
	@DataProvider
	public Object[][] GetTestData()
	{
		Object data[][]=TestUtil.getTestData(Sheetname);
		return data;
		
	}
	
	@Test(dataProvider="GetTestData")
	public void CreateNewUser(String fname, String lname,String email, String phone, String firm, String type)
	{
		homePage.ExpandAdminMenu();
		homePage.ClickOnUserLink();
		userPage.ClickOnAddUser();
		try {
		userPage.CreateNewUser(fname, lname, email, phone);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		userPage.SelectFirm(firm);
		userPage.SelectUserType(type);
		userPage.SaveUser();
		Boolean b=driver.findElement(By.xpath("//b[contains(text(),'"+fname+"')]")).isDisplayed();
		Assert.assertTrue(b, "Unable to Find the user");
		
		
	}

	
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}

}
