package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.Base;

public class HomePage extends Base {

	@FindBy(xpath="//input[@class='LM6RPg']")
	WebElement searchText;
	
	@FindBy(xpath="//button[@class='vh79eN']")
	WebElement searchBtn;
	
	@FindBy(xpath="//div[contains(text(),'My Account')]")
	WebElement myAccountText;
	
	@FindBy(xpath="//span[contains(text(),'Electronics')]")
	WebElement menubar_electronics;
	
	@FindBy(xpath="//a[@title='Mobiles']")
	WebElement submenu_mobiles;
	
	@FindBy(xpath="//a[contains(@class,'32ZSYo')] [@title='Mobiles']")
	WebElement submenu_acces_mobiles;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement searchProduct()
	{
		return searchText;
		//searchText.sendKeys(Keys.ENTER);
		
		//searchBtn.click();
	}
	public WebElement searchButton()
	{
		return searchBtn;
	}
	
	public boolean myAccountDisplay()
	{
		return myAccountText.isDisplayed();
	}
	
	public void clickOnElectronics()
	{
		menubar_electronics.click();
	}
	public WebElement menuElectronics()
	{
		return menubar_electronics;
	}
	public WebElement submenuMobiles()
	{
		return submenu_mobiles;
	}
	public WebElement submenuAccessoriesMobiles()
	{
		return submenu_acces_mobiles;
	}
}
