package com.flipkart.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.flipkart.util.TestUtil;

public class Base {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public Base() 
	{
		
		try {
			
			prop=new Properties();
			FileInputStream file=new FileInputStream(System.getProperty("user.dir")+ "\\src\\main\\java\\com\\flipkart\\config\\config.properties");
			prop.load(file);
			
		} catch(FileNotFoundException e) {
			e.printStackTrace();
			
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		
	}
	
	public static void initialization()
	{
		String browserName=prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\flipkart\\resources\\chromedriver.exe");
			driver=new ChromeDriver();
			
		}else if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\src\\main\\java\\com\\flipkart\\resources\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
		
	}
	
	public  String getActiveTabTitle()
	{
		//Fetch multiple windows using sting of array
		Set<String> ids=driver.getWindowHandles();
		Iterator<String> it=ids.iterator();
		//parent id
		it.next();
		//get the child id
		String childId=it.next();
		//get the child window title
		driver.switchTo().window(childId);
		return driver.getTitle();
		
	}

}
