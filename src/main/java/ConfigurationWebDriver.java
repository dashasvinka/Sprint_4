import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

public class ConfigurationWebDriver {
    public static WebDriver InitChromeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
        //driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    public static WebDriver InitFirefoxDriver() {
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("capability.policy.default.Window.frameElement", "allAccess");
        WebDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }

    public static WebDriver GetDriverByDriverType(DriverType driverType) {
        if (driverType == DriverType.Firefox) {
            return InitFirefoxDriver();
        } else {
            return InitChromeDriver();
        }
    }
}