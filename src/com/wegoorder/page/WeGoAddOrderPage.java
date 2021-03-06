package com.wegoorder.page;

import java.util.Set;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.concurrent.TimeUnit;
import javax.xml.xpath.XPath;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.opencsv.CSVReader;
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
	By StepOne= By.xpath("//div[@id='button-step-1']");
	By StepTwo= By.xpath("//div[@id='button-step-2']");
	By Skip = By.xpath("//*[text()='Skip']");
	By EnterCompName=By.xpath("//*[@class='css-1o90d26']");
	By CompName = By.xpath("//*[text()='Company name']");
	By Depot = By.id("input-depot-loca");
	By DepoDropdown = By.xpath("//*[@id='input-depot-loca-option-0']");
	By RoundTrip = By.xpath("//*[@id='input-depot-round-trip']");
	By Switch=By.xpath("(//div/label[@class='custom-switcher'])[1]");
	By SameAsDepot = By.xpath("//*[text()='Same as depot']");
	By NextButton = By.xpath("//*[@id='button-fleet-next']");
	By ManualTab = By.xpath("//div[@id='button-orders-mode-Manual']");
	By ImportTab=By.xpath("//div[@id='button-orders-mode-Import']");
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
	By ImportButton= By.xpath("//div[@id='button-orders-mode-Import']");
	By ImportButton_New=By.xpath("//*[@id='input-file-upload']");
	By BrowseFile=By.xpath("//div/label[.='Browse files']");
	By CSVSaveButton= By.xpath("(//div/strong[@class='css-1vqbjte'])[1]");
	By BrowserfileButon=By.xpath("//div[@id='react-file-drop-demo']");
	By ConfirmButton=By.xpath("//*[text()='Confirm']");
	

	public WeGoAddOrderPage(WebDriver driver) {
		this.driver = driver;
	}

	public void Skip() {
		driver.findElement(Skip).click();
	}

	public void FleetandDepot() {
		
		driver.findElement(StepOne).click();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElement(CompName).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(EnterCompName).sendKeys("Flipkart");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(AddressDropdown).click();
		String DepoToSelect = "Koregaon Park Plaza";
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(By.id("input-depot-loca")).sendKeys(DepoToSelect);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		List<WebElement> DepoOptions = driver.findElements(DepoDropdown);
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.MINUTES);
		int count = 0;
		for (WebElement depo : DepoOptions) {
			String currentDepo = depo.getText();
			System.out.println(currentDepo);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			if (currentDepo.contains(DepoToSelect)) {
				depo.click();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				System.out.println(depo);
				count++;
			}
			if (count != 0) {
				System.out.println(DepoToSelect + " + Has been selected as Depo");
			} else {
				System.out.println("Depo is not selected");
			}
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(Switch).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(SameAsDepot).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.findElement(NextButton).isDisplayed();
		driver.findElement(NextButton).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	}

	public void AddOrderManual() {
		for (int i = 0; i < 3; i++) {
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(StepTwo).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.findElement(ManualTab).click();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
	
	public void csvOrders() throws FileNotFoundException, AWTException
	{
		/*String csvFile = "csv\\here-wego-deliver.csv";
		File srcFile = new File(csvFile);
        String path = srcFile .getAbsolutePath();
        System.out.println("Path: "+path);*/
       
	/*	WebDriverWait wait=new WebDriverWait(driver, 20); 
		WebElement element1 = wait.until(ExpectedConditions.elementToBeClickable(BrowseFile));
		driver.findElement(BrowseFile).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.switchTo().activeElement().sendKeys("C:\\Users\\Sunil\\here-wego-deliver-template.csv");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(CSVSaveButton).click();*/
		
		
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		 // driver.findElement(ImportTab).click();
		String s = new String("C:\\\\Users\\\\Sunil\\\\here-wego-deliver-template.csv");
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    Toolkit.getDefaultToolkit().getSystemClipboard();
	    Robot robot = new Robot();
	    robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
	    robot.keyRelease(java.awt.event.KeyEvent.VK_ENTER);
	    robot.keyPress(java.awt.event.KeyEvent.VK_CONTROL);
	    robot.keyPress(java.awt.event.KeyEvent.VK_V);
	    robot.keyRelease(java.awt.event.KeyEvent.VK_CONTROL);
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    robot.keyPress(java.awt.event.KeyEvent.VK_ENTER);
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    if(driver.findElement(CSVSaveButton).isDisplayed())
	    {
	    	System.out.println();
	    }
	    
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.findElement(CSVSaveButton).click();
	    System.out.println("File Uploaded");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	   
	  /*  if(driver.findElement(ConfirmButton).isDisplayed())
	    {
	    	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    	driver.findElement(ConfirmButton).click();
	    	System.out.println("Confirm Button is Displayed");
	    }
	    else*/
	    
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    System.out.println("Order Created from CSV File");
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    
	    
	}
}
