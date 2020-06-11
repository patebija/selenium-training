package com.qascript;

import com.qascript.utils.Common.PropertyFileUtils;
import com.qascript.utils.Selenium.GetDriver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseClass {

    public static WebDriver driver;

    @BeforeSuite
    public void setup(){

        String browser = PropertyFileUtils.loadFrameworkProperties().getProperty("webdriver.driver");
        String url = PropertyFileUtils.loadApplicationProperties().getProperty("application.url");
        driver = GetDriver.initializeDriver(browser);
        driver.get(url);

    }

    @AfterSuite
    public void teardown(){
        GetDriver.closeDriver();
    }
}
