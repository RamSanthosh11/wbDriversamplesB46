package testscripts;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoteWebDriverTest {
	WebDriver driver;
  @Test
  public void f() throws MalformedURLException{
	  ChromeOptions options = new ChromeOptions();
	  options.setCapability(CapabilityType.PLATFORM_NAME,Platform.WINDOWS);
	  
	  String strHub = " http://192.168.1.4:4444";
	  
	  driver =new RemoteWebDriver(new URL(strHub),options);
	  
	  driver.manage().window().maximize();
	  driver.get("https://www.google.com/");
	  WebElement searchBox = driver.findElement(By.tagName("textarea"));
	  searchBox.sendKeys("Appium Tutorial");
	  searchBox.submit();
	  //Thread.sleep(2000);
	  Assert.assertEquals(driver.getTitle(), "Appium Tutorial - Google Search");
  }
}
