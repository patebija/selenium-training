package com.qascript;

import com.qascript.utils.Common.PropertyFileUtils;
import com.qascript.utils.Selenium.GetDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.*;

public class BaseClass {

    public static WebDriver driver;

    @BeforeClass
    @Parameters({"browser"})
    public void setup(@Optional("chrome") String browser){

        //String browser = PropertyFileUtils.loadFrameworkProperties().getProperty("webdriver.driver");
        String url = PropertyFileUtils.loadApplicationProperties().getProperty("application.url");
        driver = GetDriver.initializeDriver(browser);
        driver.get(url);
        try {
            synchronized (driver)
            {
                driver.wait(4500);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @AfterClass
    public void teardown(){
        GetDriver.closeDriver();
    }
}
