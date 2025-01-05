package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GooglePageTest {
	// Declaration (no object created here, just a reference variable of type WebDriver)
	WebDriver driver;
  @Test
  public void seleniumsearchTest() {
	  
	// Initialization (creating the actual browser object)
	  driver = new ChromeDriver();// Here, ChromeDriver is the concrete class that implements WebDriver
	  //driver.get("https://www.google.com/");
	  driver.navigate().to("https://www.google.com/");
	  // WebElement searchBox = driver.findElement(By.id("APjFqb"));
	  //WebElement searchBox = driver.findElement(By.name("q"));
	  //WebElement searchBox = driver.findElement(By.className("gLFyf"));
	  WebElement searchBox = driver.findElement(By.tagName("textarea"));
	  searchBox.sendKeys("Selenium Tutorial");
	  //searchBox.sendKeys(Keys.ENTER);
	  searchBox.submit();
	  System.out.println("Page tittle..."+driver.getTitle());
	  driver.navigate().back();
	  
	  System.out.println("Page tittle after back()..."+driver.getTitle());
	  driver.navigate().forward();
	  
	  System.out.println("Page URL " + driver.getCurrentUrl());
	  //Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
	  
  }
}
