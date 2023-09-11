package selenium4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class RelativeLocators {
    WebDriver driver;
    @BeforeClass
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://automationbookstore.dev/");
    }

    @Test(description = "Test Book 5 which is left of book 6 and below book 1")
    void test1(){
        WebElement book5 = driver.findElement(RelativeLocator.with(By.tagName("li")).toLeftOf(By.id("pid6")).below(By.id("pid1")));
        System.out.println(book5.getAttribute("id"));
    }

    @Test(description = "Test Book 2 which is right of book 1 and above book 6")
    void test2(){
        WebElement book2 = driver.findElement(RelativeLocator.with(By.tagName("li")).toRightOf(By.id("pid1")).above(By.id("pid6")));
        System.out.println(book2.getAttribute("id"));
    }

    @AfterClass
    void tearDown(){
        driver.close();
    }
}
