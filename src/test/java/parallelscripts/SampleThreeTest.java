package parallelscripts;

import org.testng.annotations.Test;

public class SampleThreeTest {
  @Test
  public void testone() {
	  
	  System.out.println("Testone31 is executing..");
  }
  @Test
 public void testtwo() {
	  
	  System.out.println("Testwo32 is executing..");
  }
  @Test(groups="featurethree")
 public void testhree() {
	  
	  System.out.println("Testhree33 is executing..");
 }
  @Test(groups="featureone")
 public void testfour() {
	  
	  System.out.println("Testfour34 is executing..");
 }
}
