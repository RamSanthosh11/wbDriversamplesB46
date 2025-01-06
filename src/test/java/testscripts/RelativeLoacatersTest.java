package testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.openqa.selenium.support.locators.RelativeLocator;

public class RelativeLoacatersTest {
    @Test
    public void f() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://automationbookstore.dev/");
        driver.manage().window().maximize();

        // Using relative locators to identify the element
        String strid = driver.findElement(
                RelativeLocator.with(By.tagName("li"))
                        .toLeftOf(By.id("pid6"))
                        .below(By.id("pid1")))
                .getAttribute("id");

        System.out.println(strid);

        driver.quit();
    }
}
