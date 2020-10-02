package com.flipkart.testcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.flipkart.base.Base;
import com.flipkart.pages.HomePage;
import com.flipkart.pages.LoginPage;
import com.flipkart.pages.MobileDetailsPage;
import com.flipkart.pages.MobilesPage;
import com.flipkart.pages.ProductDetailsPage;
import com.flipkart.util.TestUtil;

public class SearchProductDetails extends Base {
	
	LoginPage objLoginPage;
	HomePage objHomePage;
	MobileDetailsPage objMobDetailsPage;
	MobilesPage objMobilesPage;
	ProductDetailsPage objProductDetailsPage;
	public WebElement element;
	
	public SearchProductDetails()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		objLoginPage=new LoginPage();
		objHomePage=new HomePage();
		objProductDetailsPage=new ProductDetailsPage();
		objMobDetailsPage=new MobileDetailsPage();
	}
	
	//testcase for search mobile from search section.
	
	@Test(priority=1)
	public void searchMobileDetails() throws InterruptedException
	{
		
			objHomePage=objLoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			if(objHomePage.myAccountDisplay()==false)
			{
				Thread.sleep(3000);
			}
			else
				Assert.assertEquals(objHomePage.myAccountDisplay(), true);
			
				//Enter mobile in Search text box
				objHomePage.searchProduct().sendKeys(TestUtil.SEARCH_MOBILES);
				//objHomePage.searchProduct().sendKeys(Keys.ENTER);
			
				//Clicked on Search button
				objHomePage.searchButton().click();
				
				//Check if search Results is displayed
				Assert.assertEquals(objProductDetailsPage.productFound(), true);
				
				List<WebElement> list_of_products=objProductDetailsPage.listOfProduct();
				List<WebElement> list_of_product_price=objProductDetailsPage.productPriceList();
				
				String product_name;
				String product_price;
				String currentTab;
				for(int i=0;i<list_of_products.size();i++)
				{
					product_name=list_of_products.get(i).getText();
					product_price=list_of_product_price.get(i).getText();
					if(product_name.contains(TestUtil.MOBILE_MODEL_NAME))
					{
						objMobDetailsPage=objProductDetailsPage.clickOnProductDetails();
						currentTab=super.getActiveTabTitle();
						if(currentTab.contains(TestUtil.ACTIVE_MODEL_NAME))
						{
							Assert.assertEquals(objMobDetailsPage.isDisplayModelName(), true);
							Assert.assertEquals(objMobDetailsPage.getModelName().contains(TestUtil.MOBILE_MODEL_NAME),true);
							Assert.assertEquals(product_price,objMobDetailsPage.getModelPrice());
							
						}
						break;
					}
					
				}
	}
	
	//Selecting mobile section.
	
	@Test(priority=2)
	public void selectMobileSection() throws InterruptedException
	{
		objHomePage=objLoginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		if(objHomePage.myAccountDisplay()==false)
		{
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		}
		else
			Assert.assertEquals(objHomePage.myAccountDisplay(), true);
		
		
		objHomePage.clickOnElectronics();
		objHomePage.submenuMobiles().click();
		objHomePage.submenuAccessoriesMobiles().click();
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.close();
		driver.quit();
	}

}
