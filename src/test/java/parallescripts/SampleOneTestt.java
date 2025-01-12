package parallescripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SampleOneTestt {
	
	
	WebDriver driver;
	
  @Test
  public void testone() {
	  
	  long id = Thread.currentThread().getId();
	  System.out.println("Testone11 is executing.."+id);
	  //Thread.sleep(1000);
	  driver = new ChromeDriver();
	  //driver.close();
  }
  @Test
 public void testtwo() {
	  
	  
	  long id = Thread.currentThread().getId();
	  System.out.println("Testone12 is executing.."+id);
	  driver = new ChromeDriver();
  }
  @Test
 public void testhree() {
	  
	  
	  long id = Thread.currentThread().getId();
	  System.out.println("Testone13 is executing.."+id);
	  driver = new ChromeDriver();
 }
  @Test(invocationCount=6,threadPoolSize = 2,timeOut = 10000 )
 public void testfour() {
	  
	  long id = Thread.currentThread().getId();
	  System.out.println("Testone14 is executing.."+id);
	  driver = new ChromeDriver();
 }
}
