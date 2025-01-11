package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class IframeTest {
  @Test
  public void f() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://the-internet.herokuapp.com/iframe");
	  
	  //driver.switchTo().frame("mce_0_ifr"); /* witching to iframe directly by name of iframe */
	  
	  //driver.switchTo().frame(0); //switching to iframe by index
	  
	  // finding the iframe through webelement and switching to iframe
	  WebElement iframe = driver.findElement(By.id("mce_0_ifr"));
	  driver.switchTo().frame(iframe);
	  
	  String strtext = driver.findElement(By.id("tinymce")).getText();
	  System.out.println("Text from iframe..."+strtext);
	  
	  //driver.switchTo().parentFrame(); /* siwitching to the immediate parent frame */
	  
	  driver.switchTo().defaultContent(); /* switching to the main frame */
	  driver.findElement(By.className("tox-statusbar__branding")).click();
	  //driver.quit();
  }
}
