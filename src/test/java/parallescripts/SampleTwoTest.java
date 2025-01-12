package parallescripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class SampleTwoTest {
	
	WebDriver driver;
  @Test
  public void testone() {
	  
	  long id = Thread.currentThread().getId();
	  System.out.println("Testone21 is executing.."+id);
	  //Thread.sleep(1000);
	  driver = new EdgeDriver();
	  //driver.close();
  }
  @Test
 public void testtwo() {
	  
	  
	  long id = Thread.currentThread().getId();
	  System.out.println("Testone22 is executing.."+id);
	  driver = new EdgeDriver();
	    }
  @Test
 public void testhree() {
	  
	  
	  long id = Thread.currentThread().getId();
	  System.out.println("Testone23 is executing.."+id);
	  //Thread.sleep(1000);
	  driver = new EdgeDriver();
	  //driver.close();
 }
  @Test
 public void testfour() {
	  
	  
	  long id = Thread.currentThread().getId();
	  System.out.println("Testone24 is executing.."+id);
	  //Thread.sleep(1000);
	  driver = new EdgeDriver();
	  //driver.close();
 }
}
