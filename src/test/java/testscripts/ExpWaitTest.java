package testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExpWaitTest {
  @Test
  public void expwait() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("http://uitestingplayground.com/ajax");
	  WebElement btn = driver.findElement(By.id("ajaxButton"));
	  btn.click();
	  
	  //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
	  wait.until(ExpectedConditions.textToBePresentInElement(
			  driver.findElement(By.cssSelector("div#content")), 
			  "Data loaded with AJAX get request."));
			  
	  String txt = driver.findElement(By.className("bg-success")).getText();
	  System.out.println("text after waiting..."+txt);
	  Assert.assertEquals(txt, "Data loaded with AJAX get request.");
  }
}
