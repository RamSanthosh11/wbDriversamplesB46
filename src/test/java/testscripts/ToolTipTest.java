package testscripts;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ToolTipTest {
  @Test
  public void tooltip() {
	  
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  Actions action = new Actions(driver);
	  driver.get("https://jqueryui.com/tooltip/");
	  
	  driver.switchTo().frame(0);
	  
	  WebElement inputage = driver.findElement(By.id("age"));
	  inputage.sendKeys(Keys.ARROW_DOWN); /*to scroll down */
	  action.moveToElement(inputage).perform(); /* moving the cursor to that element */
	  
	  String strtxt = driver.findElement(By.className("ui-tooltip-content")).getText();
	  System.out.println("Tooltip text is..."+strtxt);
	  Assert.assertEquals(strtxt, "We ask for your age only for statistical purposes.");
	  inputage.sendKeys("20");
  }
}
