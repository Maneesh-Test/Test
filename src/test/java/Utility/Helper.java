package Utility;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;


public class Helper extends BaseClass {

    private static Properties properties;


    public static void hardWait() {
        try {
            driver.wait(3000);
        } catch (Exception e) {
            Reporter.log("Unable wait for the element", true);
        }
    }

    public static String readProps(String ElementName) {
        String FilePath = "C:/Users/admin/IdeaProjects/Test/src/test/java/Config/Config.properties";
        try {
            properties = new Properties();
            properties.load(new FileInputStream(FilePath));
            return properties.getProperty(ElementName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return FilePath;
    }

    public static String captureScreenshot(WebDriver driver) {
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenShotPath = System.getProperty("user.dir") + "/Screenshots/Screenshot_"+ getCurrentDateTime()+".png";
        try {

            FileHandler.copy(src, new File(screenShotPath));
            System.out.println("Screenshot Captured");
        } catch (Exception e) {
            System.out.println("Unable to capture Screenshot" + e.getMessage());
        }
    return screenShotPath;
    }

    public static String getCurrentDateTime() {
        DateFormat customDate = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date now = new Date();
        return customDate.format(now);
    }

}
