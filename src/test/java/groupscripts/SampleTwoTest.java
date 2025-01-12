package groupscripts;

import org.testng.annotations.Test;

public class SampleTwoTest {
  @Test
  public void testone() {
	  
	  System.out.println("Testone21 is executing..");
  }
  @Test(groups="featurefour")
 public void testtwo() {
	  
	  System.out.println("Testwo22 is executing..");
  }
  @Test(groups="featureone")
 public void testhree() {
	  
	  System.out.println("Testhree23 is executing..");
 }
  @Test
 public void testfour() {
	  
	  System.out.println("Testfour24 is executing..");
 }
}
