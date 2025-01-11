package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GoogleSearchTest {
	
	WebDriver driver;
	
 // @BeforeMethod
  @BeforeTest
  public void beformeth() {
	  driver = new ChromeDriver();
	  
  }
  
 // @AfterMethod
  @AfterTest
  public void aftermeth() {
	  driver.close();
	  
  }
  @Test(priority=1)
  public void seleniumsearch() {
	 
	  driver.get("https://www.google.com/");
	  WebElement searchBox = driver.findElement(By.tagName("textarea"));
	  searchBox.sendKeys("Selenium Tutorial");
	  searchBox.submit();
	  Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search");
  }
  @Test(priority=2)
  public void javasearch() {
	  
	  driver.get("https://www.google.com/");
	  WebElement searchBox = driver.findElement(By.tagName("textarea"));
	  searchBox.sendKeys("Java Tutorial");
	  searchBox.submit();
	  Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");

  }
  @Test(priority=3)
  public void cucumbersearch() {
	  
	  driver.get("https://www.google.com/");
	  WebElement searchBox = driver.findElement(By.tagName("textarea"));
	  searchBox.sendKeys("Cucumber Tutorial");
	  searchBox.submit();
	  Assert.assertEquals(driver.getTitle(), "Cucumber Tutorial - Google Search");

  }
  @Test(priority=4)
  public void appiumsearch() {
	  
	  driver.get("https://www.google.com/");
	  WebElement searchBox = driver.findElement(By.tagName("textarea"));
	  searchBox.sendKeys("Appium Tutorial");
	  searchBox.submit();
	  Assert.assertEquals(driver.getTitle(), "Appium Tutorial - Google Search");

  }
}
