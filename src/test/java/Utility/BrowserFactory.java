package Utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {


    public static WebDriver startApplication(WebDriver driver, String browserName, String appUrl){
        switch (browserName) {
            case "Chrome":
                System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
                Reporter.log("=====Chrome Browser Session Started=====", true);
                driver = new ChromeDriver();
                break;
            case "Firefox":
                System.setProperty("webdriver.gecko.driver","./Drivers/geckodriver.exe");
                Reporter.log("=====Firefox Browser Session Started=====", true);
                driver = new FirefoxDriver();
                break;
            case "IE":

                break;
            default:
                Reporter.log("==Unknown Browser=", true);
                break;
        }
        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get(appUrl);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public static void quitBrowser(WebDriver driver) {
        driver.quit();

    }
}
