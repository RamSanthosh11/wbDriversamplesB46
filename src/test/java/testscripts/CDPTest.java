package testscripts;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CDPTest {
	ChromeDriver driver;
	DevTools devTools;
	@BeforeMethod
	public void setup() {
		driver = new ChromeDriver();
		devTools = driver.getDevTools();
		devTools.createSession(driver.getWindowHandle());
		
	}
  @Test
  public void devicemodeTest() {
	  Map deviceMetrics = new HashMap() {{
		  put("width",800);
		  put("height",1100);
		  put("deviceScaleFactor",50);
		  put("mobile",true);
		  
	  }};
	  driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",deviceMetrics);
	  driver.get("https://www.selenium.dev/");
	  
}
  @Test
  public void geoLocationTest() {
	  Map deviceMetrics = new HashMap() {{
		  put("latitude",27.664827);
		  put("longitude",-81.515755);
		  put("accuracy",50);
		  
	  }};
	  driver.executeCdpCommand("Emulation.setGeolocationOverride",deviceMetrics);
	  driver.get("https://oldnavy.gap.com/stores");
	  
}
}
