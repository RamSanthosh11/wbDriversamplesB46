package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JSExecTest {//1
  @Test
  public void f() {
	  WebDriver driver = new ChromeDriver();
	  driver.manage().window().maximize();
	  driver.get("https://ecommerce-playground.lambdatest.io/");
	  
	  JavascriptExecutor js = (JavascriptExecutor)driver;  //converting driver in to java script executor object
	  String strTitle = (String)js.executeScript("return document.title"); //executeScript has methods
	  System.out.println(strTitle);
	  
	  WebElement searchbox = (WebElement)js.executeScript(
			  "return document.getElementsByName('search')[0]");
	  searchbox.sendKeys("Phone");
	  
	  driver.findElement(By.cssSelector("button.type-text")).click();
	  js.executeScript("history.go(-1)");
	  js.executeScript("window.scrollBy(10,700)");
	  js.executeScript("window.scrollBy(10,document.body.scrollHeight)");

	  
  }
}
