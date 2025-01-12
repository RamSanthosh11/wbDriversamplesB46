package groupscripts;

import org.testng.annotations.Test;

public class SampleOneTest {
  @Test
  public void testone() {
	  
	  System.out.println("Testone11 is executing..");
  }
  @Test(groups="featureone")
 public void testtwo() {
	  
	  System.out.println("Testwo12 is executing..");
  }
  @Test
 public void testhree() {
	  
	  System.out.println("Testhree13 is executing..");
 }
  @Test(groups="featuretwo")
 public void testfour() {
	  
	  System.out.println("Testfour14 is executing..");
 }
}
