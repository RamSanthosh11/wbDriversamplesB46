package testscripts;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class WindowPopupTest {
  @Test
  public void winpop()  {
	  WebDriver driver = new ChromeDriver();
	  Actions actions = new Actions(driver);
	  driver.get("https://demoqa.com/browser-windows");
	  driver.manage().window().maximize();
	  
	  String parentwin = driver.getWindowHandle(); /* to get the cureent window handle */
	  //Thread.sleep(5000);
	  actions.scrollByAmount(100, 1200).perform();
	  System.out.println("parent win..."+parentwin);
	  driver.findElement(By.id("tabButton")).click();
	  System.out.println("page title...."+driver.getTitle());
	  
	  Set<String> wins = driver.getWindowHandles(); /* to get the all  window handles */
	  System.out.println("No of windows.."+wins.size()); /* number of window handles */
	  
	  for(String child : wins) {
		  System.out.println("Wind handles.."+child);
		  if(!child.equalsIgnoreCase(parentwin)) {
			  driver.switchTo().window(child);
			  String h1TagText = driver.findElement(By.id("sampleHeading")).getText();
			  System.out.println("Text in Tab Window"+h1TagText);
		  }
	  }
	  
	  driver.close();
	  driver.switchTo().window(parentwin);
	  driver.findElement(By.id("windowButton")).click();
	   
	  Set<String> popwins = driver.getWindowHandles();
	  System.out.println("No of windows.."+popwins.size());
	  
	  for(String child : popwins) {
		  System.out.println("Wind handles.."+child);
		  if(!child.equalsIgnoreCase(parentwin)) {
			  driver.switchTo().window(child);
			  String h1TagText = driver.findElement(By.id("sampleHeading")).getText();
			  System.out.println("Text in popup window"+h1TagText);
		  }
	  }
	 // driver.close(); /* closes the current window */
	  //driver.quit(); /* closes the webdriver */
	  //driver.switchTo().newWindow(WindowType.TAB); /*opens new url in new tab */
	  driver.switchTo().newWindow(WindowType.WINDOW);  /* opens new window in the driver */
	  driver.get("https://testautomationpractice.blogspot.com/");
	  driver.quit();
	  
	  
  }
}
