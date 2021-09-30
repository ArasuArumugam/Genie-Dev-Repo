package com.genie.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.genie.qa.base.TestBase;

public class UserPage extends TestBase{

	@FindBy(xpath="//button[@id='btnNewUser']")
	WebElement AddNewUser;
	
	@FindBy(xpath="//input[@id='fname']")
	WebElement Fname;
	
	@FindBy(xpath="//input[@id='lname']")
	WebElement Lname;

	@FindBy(xpath="//input[@id='email']")
	WebElement Email;
	
	@FindBy(xpath="//input[@id='phone_number']")
	WebElement Phone;
	
	@FindBy(xpath="//button[@id='saveNewUserId']")
	WebElement Save;
	
	@FindBy(xpath="//label[contains(text(),'Firm End Client User')]")
	WebElement EndClientUser;
	
	@FindBy(xpath="//label[contains(text(),'Firm User')]")
	WebElement FirmUser;
	
	
	public UserPage() {
		PageFactory.initElements(driver,this);
	}
	
	public void ClickOnAddUser()
	{
		AddNewUser.click();
	}
	public void SelectFirm(String FirmName)
	{
	
		//driver.findElement(By.xpath("//select[@id='selectCompanyUser']")).click();
		//Select s=new Select(driver.findElement(By.id("selectCompanyUser")));
		//System.out.println(s.toString());
		//s.selectByVisibleText(FirmName);	
		
		driver.findElement(By.xpath("//select[@id='selectCompanyUser']")).click();
		driver.findElement(By.xpath("//select[@id='selectCompanyUser']//option[text()=\""+FirmName+"\"]")).click();
		//driver.findElement(By.xpath(String.format("//select[@id='selectCompanyUser']//option[text()=\"%s\"]",FirmName))).click();
	}
	
	public void CreateNewUser(String Firstname, String Lastname, String Emailid, String Phoneno)
	{
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", AddNewUser);
		Fname.sendKeys(Firstname);
		Lname.sendKeys(Lastname);
		Email.sendKeys(Emailid);
		Phone.sendKeys(Phoneno);
	}
	
	public void SelectUserType(String type)
	{
		if (type=="EndClientUser")
			EndClientUser.click();
		
		else
			FirmUser.click();
	}
	
	public void SaveUser()
	{
		Save.click();
	}
	
	
}
