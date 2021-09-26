/**
 * 
 */
package com.fleetanddepot.Testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.wegoorder.page.WeGoAddOrderPage;

/**
 * @author Sunil
 *
 */
public class FleetandDeport {

	@Test
	public void FleetandDepot() {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//Sunil//Downloads//chromedriver_win32//chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://wegodeliver.here.com/");

		WeGoAddOrderPage Fleet = new WeGoAddOrderPage(driver);
		Fleet.Skip();
		driver.findElement(By.xpath("//*[@id='button-fleet-next']")).click();
		// Fleet.FleetandDepot();
		Fleet.AddOrderManual();
		Fleet.TourCheck();
		driver.quit();
	}

	/*
	 * @Test public void VerifyAddOrder() { WeGoAddOrderPage AddOrder= new
	 * WeGoAddOrderPage(driver); AddOrder.AddOrderManual(); }
	 */

}
