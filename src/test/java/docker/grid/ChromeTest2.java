package docker.grid;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class ChromeTest2 {
    @Test
    public void test() throws MalformedURLException {
        ChromeOptions chrome = new ChromeOptions();
        URL url=new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver=new RemoteWebDriver(url,chrome);
        driver.get("https://www.facebook.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
