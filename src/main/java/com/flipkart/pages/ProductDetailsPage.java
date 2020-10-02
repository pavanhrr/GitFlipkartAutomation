package com.flipkart.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.flipkart.base.Base;

public class ProductDetailsPage extends Base {
	
	@FindBy(xpath="//span[contains(text(),'Showing 1 – 24')]")
	WebElement search_result_text;
	
	@FindBy(xpath="//div[@class='_3wU53n']")
	List<WebElement> product_name_list;
	
	@FindBy(xpath="//div[contains(text(),'Realme Narzo 20 (Glory Sliver, 64 GB)')]")
	WebElement click_on_product;
	
	@FindBy(xpath="//div[@class='_1vC4OE _2rQ-NK']")
	List<WebElement> product_price_list;
	
	public ProductDetailsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public boolean productFound()
	{
		return search_result_text.isDisplayed();
	}
	
	public List<WebElement> listOfProduct()
	{
		return product_name_list;
	}
	
	public List<WebElement> productPriceList()
	{
		return product_price_list;
	}
	
	public MobileDetailsPage clickOnProductDetails()
	{
		click_on_product.click();
		return new MobileDetailsPage();
	}

}
