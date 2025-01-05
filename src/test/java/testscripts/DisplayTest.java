package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DisplayTest {
	
	WebDriver driver;
  @Test
  public void f() {
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://automationbookstore.dev/");
	  driver.findElement(By.id("searchBar")).sendKeys("Test");
	  WebElement closeIcon =driver.findElement(
			  By.cssSelector("a[title='Clear text']"));
	  System.out.println(closeIcon.isDisplayed());
	  
	 if(closeIcon.isDisplayed())
	 {
		 closeIcon.click();
	 }
  }
}
