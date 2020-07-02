package com.qascript;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.qascript.utils.Common.PropertyFileUtils;
import com.qascript.utils.Selenium.GetDriver;
import jdk.nashorn.internal.objects.NativeMath;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

public class BaseClass {

    public static WebDriver driver;
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;

    @BeforeClass
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browser) {

        //String browser = PropertyFileUtils.loadFrameworkProperties().getProperty("webdriver.driver");
        String url = PropertyFileUtils.loadApplicationProperties().getProperty("application.url");
        driver = GetDriver.initializeDriver(browser);
        driver.get(url);
        try {
            synchronized (driver) {
                driver.wait(4500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @BeforeTest
    @Parameters({"OS", "browser"})
    public static void startReport(String OS, String browser) {
        htmlReporter = new ExtentHtmlReporter("extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("OS", OS);
        extent.setSystemInfo("Browser", browser);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Extent Reports");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");

    }

    @AfterMethod
    public static void getResult(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {

            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + "PASSED", ExtentColor.GREEN));

        } else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + "SKIPPED", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }
    }

    @AfterTest
    public void teardown() {
        GetDriver.closeDriver();
        extent.flush();
    }
}

