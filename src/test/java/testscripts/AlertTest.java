package testscripts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertTest {
  @Test
  public void alertest() {
	  WebDriver driver = new ChromeDriver();
	  driver.get("https://testautomationpractice.blogspot.com/");
	  driver.manage().window().maximize();
	  
	  //simple alert
	  driver.findElement(By.id("alertBtn")).click();
	  Alert alert = driver.switchTo().alert();
	  System.out.println(alert.getText());
	  alert.accept();
	  
	  //confirmation alert
	  driver.findElement(By.id("confirmBtn")).click();
	  Alert confirm = driver.switchTo().alert();
	  System.out.println(confirm.getText());
	  confirm.dismiss();
	  
	  //prompt alert
	  driver.findElement(By.id("promptBtn")).click();
	  Alert prompt = driver.switchTo().alert();
	  System.out.println(prompt.getText());
	  prompt.sendKeys("Hello Welcome");
	  prompt.accept();
	  
	  
	  
  }
}
