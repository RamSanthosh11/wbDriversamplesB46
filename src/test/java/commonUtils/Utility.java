package commonUtils;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Utility {
	public static String getScreenshotPath(WebDriver driver){
 
	      //Entire Page
		  TakesScreenshot screen = (TakesScreenshot)driver;
		  File src = screen.getScreenshotAs(OutputType.FILE);
		  String srcFile= System.getProperty("user.dir")
				  +"/screenshots/" + System.currentTimeMillis() +".png";
		  File dest = new File(srcFile);
		  try {
			  FileUtils.copyFile(src, dest);
		  }catch(IOException e) {
			  e.printStackTrace();
		  }
		  return srcFile;
		  
		 }
	  }
