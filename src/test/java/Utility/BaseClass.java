
package Utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

public class BaseClass {

    public static WebDriver driver;
    public ExtentReports report;
    public ExtentTest logger;
    public ExcelDataProvider excel;
    public ConfigDataProvider config;

    @BeforeSuite
    public void setUpSuite() {
        ExtentHtmlReporter extent = new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/target/extent-report/myReport_" + Helper.getCurrentDateTime() + ".html"));
        report = new ExtentReports();
        report.attachReporter(extent);
        excel = new ExcelDataProvider();
        config = new ConfigDataProvider();
    }

    @BeforeClass
    public void setupApplication() {
        driver = BrowserFactory.startApplication(driver, config.getFirefoxBrowser(), config.getUrl());
        driver.get(config.getUrl());
        Reporter.log("=====Application Started=====", true);
    }

    @AfterClass
    public void closeApplication() {
        BrowserFactory.quitBrowser(driver);
        Reporter.log("=====Browser Session End=====", true);

    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            Helper.captureScreenshot(driver);
            logger.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            logger.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());

        }
        report.flush();
    }


}