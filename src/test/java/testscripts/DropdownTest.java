package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class DropdownTest {
	
	WebDriver driver;
  @Test
  public void selectValue() {
	  
	  driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://testautomationpractice.blogspot.com/");
	  Select sel = new Select(driver.findElement(By.id("country")));
//	  sel.selectByValue("uk");
//	  sel.selectByVisibleText("United Kingdom");
	  sel.selectByIndex(9);
  }
}
