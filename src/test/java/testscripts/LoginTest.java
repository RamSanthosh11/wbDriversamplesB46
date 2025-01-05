package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginTest {
	
	WebDriver driver;
  @Test
  public void validLogin() {
	  
	  driver =new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/login");
	  driver.manage().window().maximize();
	  driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
	  driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
	  //driver.findElement(By.className("radius")).click();
	  //driver.findElement(By.className("fa fa-2x fa-sign-i"));
	  //css driver.findElement(By.cssSelector("button.radius")).click();
	  driver.findElement(By.cssSelector("i.fa.fa-2x.fa-sign-in")).click();
	  //driver.findElement(By.xpath("//i[@class='fa fa-2x fa-sign-in']")).click();
	  //driver.findElement(By.linkText("Elemental Selenium")).click();
	  driver.findElement(By.partialLinkText("Elemental")).click();
  }
}
