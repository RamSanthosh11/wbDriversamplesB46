package testscripts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.ViewName;

import commonUtils.Utility;

public class ExtendReportTest {
	
	WebDriver driver;
	ExtentReports extentreports;
	ExtentSparkReporter spark;
	ExtentTest extentTest;
	
   @BeforeTest
  public void setupExtent() {
	  extentreports = new ExtentReports();
	  spark = new ExtentSparkReporter("test-output/SparkReporter.html")
			  .viewConfigurer()
			  .viewOrder()
			  .as(new ViewName[] {
					  ViewName.DASHBOARD,
					  ViewName.TEST,
					  ViewName.AUTHOR,
					  ViewName.DEVICE,
					  ViewName.LOG
					  }).apply();
	  extentreports.attachReporter(spark);	  
  }
  @BeforeMethod
  public void Setup() {
	  driver = new ChromeDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	  driver.manage().window().maximize();

  }
  @AfterMethod
  public void afterMethod(ITestResult result) {
	  
	  extentTest.assignAuthor("AutomationTester1")
	  .assignCategory("Regression")
	  .assignDevice(System.getProperty("os.name"))
	  .assignDevice(System.getProperty("os.version"));
		
      // Check if the test failed
      if (result.getStatus() == ITestResult.FAILURE) {
          // Log failure message in Extent Report
          extentTest.log(Status.FAIL, result.getThrowable().getMessage());
          String strpath = Utility.getScreenshotPath(driver);
          extentTest.fail(MediaEntityBuilder.createScreenCaptureFromPath(strpath).build());
      }
      driver.close();
  }
  @AfterTest
  public void finishExtent() {
	  extentreports.flush();
  }
  @Test
  public void seleniumsearch() throws InterruptedException {
	  
	  extentTest = extentreports.createTest("Selenium Search Test");
	  driver.get("https://www.google.com/");
	  WebElement searchBox = driver.findElement(By.tagName("textarea"));
	  searchBox.sendKeys("Selenium Tutorial");
	  searchBox.submit();
	  Thread.sleep(2000);
	  Assert.assertEquals(driver.getTitle(), "Selenium Tutorial - Google Search11");
  }
  @Test(alwaysRun = true, dependsOnMethods="seleniumsearch")
  public void javasearch() throws InterruptedException {
	  
	  extentTest = extentreports.createTest("Java Search Test");
	  driver.get("https://www.google.com/");
	  WebElement searchBox = driver.findElement(By.tagName("textarea"));
	  searchBox.sendKeys("Java Tutorial");
	  searchBox.submit();
	  Thread.sleep(2000);
	  Assert.assertEquals(driver.getTitle(), "Java Tutorial - Google Search");

  }
  @Test
  public void cucumbersearch() throws InterruptedException {
	  
	  extentTest = extentreports.createTest("cucumber Search Test");
	  driver.get("https://www.google.com/");
	  WebElement searchBox = driver.findElement(By.tagName("textarea"));
	  searchBox.sendKeys("Cucumber Tutorial");
	  searchBox.submit();
	  Thread.sleep(2000);
	  Assert.assertEquals(driver.getTitle(), "Cucumber Tutorial - Google Search");

  }
  @Test
  public void appiumsearch() throws InterruptedException {
	  
	  extentTest = extentreports.createTest("appium Search Test");
	  driver.get("https://www.google.com/");
	  WebElement searchBox = driver.findElement(By.tagName("textarea"));
	  searchBox.sendKeys("Appium Tutorial");
	  searchBox.submit();
	  Thread.sleep(2000);
	  Assert.assertEquals(driver.getTitle(), "Appium Tutorial - Google Search");

  }
}
