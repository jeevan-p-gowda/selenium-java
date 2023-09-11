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

public class Screenshot {
    WebDriver driver;

    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://demo.nopcommerce.com/");
        driver.manage().window().maximize();
    }

    @Test(description = "Take a screenshot of particular section of a page")
    void screenshotSectionOfPage() throws IOException {
        WebElement element = driver.findElement(By.xpath("//div[@class='product-grid home-page-product-grid']"));
        highlightElement(element, driver);
        File file = element.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./screenshots/productSection.png");
        FileUtils.copyFile(file, destFile);
    }

    /**
     * Highlights image with colored border
     */
    void highlightElement(WebElement webElement, WebDriver driver) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].style.border='2px solid red'", webElement);

    }

    @AfterClass
    void tearDown() {
        driver.quit();
    }
}
