package com.qascript.utils.Selenium;

import com.qascript.utils.Common.PropertyFileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.concurrent.TimeUnit;

public class GetDriver {

    public static WebDriver driver;

    public static WebDriver initializeDriver(String browser){
        int pageLoadTimeout = Integer.parseInt(PropertyFileUtils.loadFrameworkProperties().
                getProperty("webdriver.timeouts.pageLoadTimeout"));
        boolean maximize = Boolean.parseBoolean(PropertyFileUtils.loadFrameworkProperties().
                getProperty("start.browser.maximize").trim().toLowerCase());

        if(browser!=""){
            if(driver==null){
                if(browser.equalsIgnoreCase("chrome")){
                    driver = setChromeDriver();
                }
                if(browser.equalsIgnoreCase("firefox")){
                    driver = setFirefoxDriver();
                }
                if(browser.equalsIgnoreCase("ie")){
                    driver = setIEDriver();
                }
                //setPageLoadTimeout(pageLoadTimeout);
                if(maximize)
                    maximizeBrowser();
            }
        }

        return driver;
    }

    private static void maximizeBrowser(){
        driver.manage().window().maximize();
    }

    private static void setPageLoadTimeout(int pageLoadTimeout) {
        driver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
    }

    private static WebDriver setChromeDriver() {
        String chromeDriverPath = PropertyFileUtils.loadFrameworkProperties().getProperty("webdriver.chrome.driver");
        System.setProperty("webdriver.chrome.driver",chromeDriverPath);
        driver = new ChromeDriver();
        return driver;
    }

    private static WebDriver setFirefoxDriver() {
        String firefoxDriverPath = PropertyFileUtils.loadFrameworkProperties().getProperty("webdriver.firefox.driver");
        System.setProperty("webdriver.gecko.driver",firefoxDriverPath);
        driver = new FirefoxDriver();
        return driver;
    }

    private static WebDriver setIEDriver() {
        String ieDriverPath = PropertyFileUtils.loadFrameworkProperties().getProperty("webdriver.ie.driver");
        System.setProperty("webdriver.ie.driver",ieDriverPath);
        driver = new InternetExplorerDriver();
        return driver;
    }

    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }
}
