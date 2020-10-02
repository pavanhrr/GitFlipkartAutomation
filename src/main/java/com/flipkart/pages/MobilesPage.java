package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.Base;

public class MobilesPage extends Base {
	
	@FindBy(xpath="//div[@data-id='MOBFVEATBBRGJBKH']")
	WebElement mobile;
	
	public MobilesPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getMobile()
	{
		return mobile;
	}

}
