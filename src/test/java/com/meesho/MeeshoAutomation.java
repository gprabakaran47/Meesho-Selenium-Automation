package com.meesho;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

// This class represents a Selenium test project for interacting with the Meesho website.

public class MeeshoAutomation {

	public static WebDriver driver;

	// Setup method to initialize WebDriver before tests.
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver();
	}

	// Test method to launch the Meesho website.
	@Test(priority = 1)
	public void launch() {
		driver.get("https://www.meesho.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// Test method to search for a product.
	@Test(priority = 2)
	public void search() throws InterruptedException {
		WebElement search = driver.findElement(By.xpath("(//*[@type='text'])[1]"));
		search.sendKeys("SHOES");
		search.sendKeys(Keys.ENTER);
		Thread.sleep(3000);
	}

	// Test method to apply product filters.
	@Test(priority = 3)
	public void product_filter() throws InterruptedException {
		driver.findElement(By.xpath("//span[text()='Casual Shoes']")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@label='Men']")).click();

	}

	// Test method to select and add a shoe to the cart.
	@Test(priority = 4)
	public void shoe() throws InterruptedException {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@alt='Latest Graceful Men Casual Shoes']")).click();
		Thread.sleep(3000);
		WebElement size = driver.findElement(By.xpath("//span[text()='IND-8']"));
		size.click();
		if (size.isDisplayed()) {
			System.out.println("IND-8 Clickable");
		} else {
			System.out.println("Not Clickable");
		}
		driver.findElement(By.xpath("//span[text()='Add to Cart']")).click();
	}
	// Method to close the WebDriver after tests.

	@AfterTest
	public void close() {
		driver.close();

	}
}
