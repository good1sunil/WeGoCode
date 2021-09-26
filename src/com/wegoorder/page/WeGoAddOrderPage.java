package com.wegoorder.page;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

/**
 * 
 * @author Sunil This class will store all the locator and methods of WeGo Add
 *         Order Page.
 */

public class WeGoAddOrderPage

{
	WebDriver driver;

	By Skip = By.xpath("//*[text()='Skip']");
	By CompName = By.xpath("//*[text()='Company name']");
	By Depot = By.id("input-depot-loca");
	By DepoDropdown = By.xpath("//*[@id='input-depot-loca-option-0']");
	By RoundTrip = By.xpath("//*[@id='input-depot-round-trip']");
	By SameAsDepot = By.xpath("//*[text()='Same as depot']");
	By NextButton = By.xpath("//*[@id='button-fleet-next']");
	By ManualTab = By.xpath("//*[text()='Manual']");
	By Name = By.xpath("//*[@id='input-edit-order-name']");
	By Address = By.xpath("//*[@id='input-edit-order-add']");
	By Phone = By.xpath("//*[@id='input-edit-order-phone']");
	By PlusButton = By.xpath("//*[@id='button-add-order-manual']");
	By NextButtonManualTab = By.xpath("//div[@id='button-orders-next']");
	By PlanTour = By.xpath("//div[@id='button-orders-next']");
	By VerifyTour = By.xpath("//h1[@class='css-17m1rwz']");
	By DeleteOrder = By.xpath("//div[contains(@id,'button-remove-order')]");
	By AddressDropdown = By.xpath("//input[@placeholder='Type address here, including the city...']");
	By AdressOptionsList = By.xpath("//div[@class='css-1b82f32']");

	public WeGoAddOrderPage(WebDriver driver) {
		this.driver = driver;
	}

	public void Skip() {
		driver.findElement(Skip).click();
	}

	public void FleetandDepot() {
		// driver.findElement(CompName).click();
		// WebDriverWait wait = new WebDriverWait(driver,10);
		// driver.findElement(CompName).sendKeys("Flipkart");
		driver.findElement(Depot).sendKeys("Rohan");
		Select objSelect = new Select(driver.findElement(DepoDropdown));
		objSelect.selectByIndex(0);
		driver.findElement(RoundTrip).click();
		driver.findElement(SameAsDepot).click();
		driver.findElement(NextButton).click();
	}

	public void AddOrderManual() {
		for (int i = 0; i < 3; i++) {
			driver.findElement(ManualTab).click();
			driver.findElement(Name).sendKeys("Sunil Chaudhari");
			driver.findElement(AddressDropdown).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			String AddresstoSelect = "Pune, Maharashtra, India";
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(By.id("input-edit-order-add")).sendKeys(AddresstoSelect);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			List<WebElement> options = driver.findElements(AdressOptionsList);
			driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
			int count = 0;
			for (WebElement option : options) {
				String currentOption = option.getText();
				System.out.println(currentOption);
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				if (currentOption.contains(AddresstoSelect)) {
					option.click();
					driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
					System.out.println(option);
					count++;
				}
				if (count != 0) {
					System.out.println(AddresstoSelect + " + Has been selected in the DD");
				} else {
					System.out.println("Address is not selected");
				}
			}
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.findElement(Phone).sendKeys("1234567890");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.findElement(PlusButton).click();
			driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
		}
		driver.findElement(DeleteOrder).isDisplayed();
		driver.findElement(PlanTour).isDisplayed();
		driver.findElement(PlanTour).click();
	}

	public void TourCheck() {
		WebElement TourLabel = driver.findElement(VerifyTour);
		if (TourLabel.isDisplayed()) {
			System.out.println("Tour is Created");
		} else {
			System.out.println("tour is not created");
		}
	}
}
