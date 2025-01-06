package testscripts;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class MouseActionsTest {
  @Test
  public void mouseactions() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://testautomationpractice.blogspot.com/#");
	  Actions action = new Actions(driver);
	  driver.manage().window().maximize();
	  WebElement ele = driver.findElement(By.id("field2"));
	  action.scrollToElement(ele).perform();
	  WebElement ele1 = driver.findElement(By.xpath("//button[contains(text(),'Point Me')]"));
	  action.moveToElement(ele1).perform();
	  WebElement ele2 = driver.findElement(By.linkText("Laptops"));
	  action.click(ele2).perform();
	  
  }
}
