/**
 * 
 */
package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.Base;

public class LoginPage extends Base {
	
	@FindBy(xpath="//input[@class='_2zrpKA _1dBPDZ']")
	WebElement username;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	@FindBy(css="button[class*='UHT_c']")
	WebElement loginBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public HomePage login(String user,String pwd)
	{
		try {
			username.sendKeys(user);
			password.sendKeys(pwd);
			loginBtn.click();
		}
		catch(org.openqa.selenium.StaleElementReferenceException ex)
		{
			loginBtn.click();
		}
		
		
		return new HomePage();
	}

}
