package parallescripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class SampleThreeTest {
	
	
	WebDriver driver;
	
  @Test
  public void testone() {
	  
	  long id = Thread.currentThread().getId();
	  System.out.println("Testone31 is executing.."+id);
	  //Thread.sleep(1000);
	  driver = new ChromeDriver();
	  //driver.close();
  }
  @Test
 public void testtwo() {
	  
	  
	  long id = Thread.currentThread().getId();
	  System.out.println("Testone32 is executing.."+id);
	  driver = new ChromeDriver();
  }
  @Test
 public void testhree() {
	  
	  
	  long id = Thread.currentThread().getId();
	  System.out.println("Testone33 is executing.."+id);
	  driver = new ChromeDriver();
 }
  @Test
 public void testfour() {
	  
	  long id = Thread.currentThread().getId();
	  System.out.println("Testone34 is executing.."+id);
	  driver = new ChromeDriver();
 }
}
