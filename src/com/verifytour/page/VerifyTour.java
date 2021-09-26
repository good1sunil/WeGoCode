package com.verifytour.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.wegoorder.page.WeGoAddOrderPage;

public class VerifyTour 
{
	public void TourCheck1()
	{
	System.setProperty("webdriver.chrome.driver","C://Users//Sunil//Downloads//chromedriver_win32//chromedriver.exe");
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://wegodeliver.here.com/");
	
	WeGoAddOrderPage TourVerifyCheck= new WeGoAddOrderPage(driver);
	TourVerifyCheck.TourCheck();
	
	driver.quit();
	}

}
