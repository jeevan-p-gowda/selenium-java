package selenium4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v116.log.Log;
import org.openqa.selenium.devtools.v116.network.Network;
import org.openqa.selenium.devtools.v116.network.model.ConnectionType;
import org.openqa.selenium.devtools.v116.security.Security;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Optional;

import static org.openqa.selenium.devtools.v116.network.Network.emulateNetworkConditions;
import static org.openqa.selenium.devtools.v116.network.Network.loadingFailed;
import static org.testng.Assert.assertEquals;

public class ChromeDevTools {
    WebDriver driver;
    DevTools devTools;

    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        devTools = ((ChromiumDriver) driver).getDevTools();
        devTools.createSession();
    }

    @Test
    void enableNetworkOffline() {
        devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
        devTools.send(emulateNetworkConditions(true,100,1000,2000,Optional.of(ConnectionType.WIFI)));
//        driver.get("https://www.saucedemo.com/");
        devTools.addListener(loadingFailed(),loadingFailed -> assertEquals(loadingFailed.getErrorText(), "net::ERR_INTERNET_DISCONNECTED"));
    }

    @Test
    void enableNetworkOnline() {
        devTools.send(Network.enable(Optional.of(1000000), Optional.empty(), Optional.empty()));
        devTools.send(emulateNetworkConditions(false,100,1000,2000,Optional.of(ConnectionType.WIFI)));
        driver.get("https://www.saucedemo.com/");

    }

//    @Test
//    void consoleLogs(){
//        devTools.send(Log.enable());
//        devTools.addListener(Log.entryAdded(), entry -> System.out.println(entry.asSeleniumLogEntry()));
//        driver.get("https://www.saucedemo.com/");
//    }

    @Test
    void loadInsecureWebsite(){
        devTools.send(Security.setIgnoreCertificateErrors(true));
        driver.get("https://expired.badssl.com/");
    }
}