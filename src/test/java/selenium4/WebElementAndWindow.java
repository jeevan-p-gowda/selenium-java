package selenium4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class WebElementAndWindow {
    WebDriver driver;

    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }

    @Test
    void screenShotWebElement() throws IOException {
        WebElement element = driver.findElement(By.xpath("//input[@id='login-button']"));
        File destFile = new File("./screenshots/button.png");
        File file = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, destFile);
    }

    @Test
    void openNewTab() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.google.com/");
        Thread.sleep(5000);
    }

    @Test
    void openNewWindow() throws InterruptedException {
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://www.google.com/");
        Thread.sleep(5000);
    }

    @Test
    void getElementLocation() throws InterruptedException {
        WebElement element = driver.findElement(By.xpath("//input[@id='login-button']"));
        System.out.printf("Height : %s\n",element.getRect().getDimension().getHeight());
        System.out.printf("Width : %s\n",element.getRect().getDimension().getWidth());
        System.out.printf("X ordinate : %s\n",element.getRect().getX());
        System.out.printf("Y ordinate : %s",element.getRect().getY());
    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
