package docker;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

/**Make sure docker is installed, run following commands
 * 1.docker pull selenium/standalone-chrome:latest
 * 2.docker run -d -p 4444:4444 -v /dev/shm:/dev/shm selenium/standalone-chrome:latest
 *
**/

public class RunOnDocker {
    public static void main(String[] args) throws MalformedURLException {
        ChromeOptions chrome = new ChromeOptions();
        URL url=new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver=new RemoteWebDriver(url,chrome);
        driver.get("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.quit();
    }
}
