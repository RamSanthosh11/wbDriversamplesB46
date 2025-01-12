package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PropertyFileTest {
    
    WebDriver driver;
    Properties prop;
    
  @BeforeTest
  public void setuptest() throws IOException {
      prop = new Properties();
      String path = System.getProperty("user.dir") + "//src//test//resources//configfiles//config.properties";
      FileInputStream fin = new FileInputStream(path);
      prop.load(fin);
      String strBrowser = prop.getProperty("browser");
      if (strBrowser.equalsIgnoreCase("chrome")) {
          driver = new ChromeDriver();
      } 
      else if (strBrowser.equalsIgnoreCase("edge")) {
          driver = new EdgeDriver();
      }
  }
  
  @Test
  public void validLoginPopertyTest() {
      driver.get(prop.getProperty("url"));
      driver.manage().window().maximize();
      driver.findElement(By.xpath("//input[@id='username']")).sendKeys("tomsmith");
      driver.findElement(By.name("password")).sendKeys("SuperSecretPassword!");
      driver.findElement(By.cssSelector("button.radius")).click();
      driver.findElement(By.partialLinkText("Elemental")).click();
  }
}
