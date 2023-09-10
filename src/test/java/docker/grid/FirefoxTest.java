package docker.grid;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FirefoxTest {
    @Test
    public void test() throws MalformedURLException {
        FirefoxOptions firefox = new FirefoxOptions();
        URL url=new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver=new RemoteWebDriver(url,firefox);
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
