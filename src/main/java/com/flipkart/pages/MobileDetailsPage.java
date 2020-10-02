package com.flipkart.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.Base;

public class MobileDetailsPage extends Base {
	
	@FindBy(xpath="//span[@class='_35KyD6']")
	WebElement model_name;
	
	@FindBy(xpath="//div[@class='_1vC4OE _3qQ9m1']")
	WebElement model_price;
	
	public MobileDetailsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean isDisplayModelName()
	{
		return model_name.isDisplayed();
	}
	
	public String getModelName()
	{
		return model_name.getText();
	}
	
	public String getModelPrice()
	{
		return model_price.getText();
	}

}
