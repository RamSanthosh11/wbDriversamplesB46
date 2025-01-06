package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class RadiCheckBoxTest {
	
	WebDriver driver;
  @Test
  public void f() {
	  
	  driver = new ChromeDriver();
	  driver.get("https://the-internet.herokuapp.com/checkboxes");
	  driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();
	  boolean isSel = driver.findElement(
			  By.xpath("(//input[@type='checkbox'])[2]")).isSelected();
	  if(isSel)
	  {
		  driver.findElement(
				  By.xpath("(//input[@type='checkbox'])[2]")).click();
	  }
	  
	  //for raido button
	  driver.get("https://testautomationpractice.blogspot.com/");
	  boolean sele = driver.findElement(By.id("male")).isSelected();
	  System.out.println(sele);
	  if(sele==false) {
		  driver.findElement(By.id("male")).click();
	  }
	  
  }
}
