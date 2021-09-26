package com.wego.Testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.wegoorder.page.WeGoAddOrderPage;

/**
 * 
 * @author Sunil
 *
 */
public class VerifyAddManualOrder 
{
	@Test
	public void VerifyAddOrder()
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://wegodeliver.here.com/");
		WeGoAddOrderPage AddOrder= new WeGoAddOrderPage(driver);
		AddOrder.AddOrderManual();
		driver.quit();
	}
}
 