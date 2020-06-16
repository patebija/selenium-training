package com.qascript.pageObjects;

import com.qascript.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BaseClass {

    private static String linkLogin = "//span[text()='Login']//ancestor::a[1]";
    public static String linkProfile="//a[@id='profile-drop']";
    public static String linkLogout="//span[text()='Log Out']";
    public static String ddShopByCategory= "//span[text()='Shop by Category']";
    public static String txtCategories = "//a[@id='catTab71-t']";


    public static void clickLogin(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(linkLogin)))).click();

    }

    public static void clickLogout(){
        driver.findElement(By.xpath(linkProfile)).click();
        driver.findElement(By.xpath(linkLogout)).click();
    }

    public static void verifyHomePageDisplayed(){
        Assert.assertTrue(driver.findElement(By.xpath(ddShopByCategory)).isDisplayed(),
                "Home Page is not displayed");


    }

    public static List<String> getAllCategories(){
        List<String>allCategories = new ArrayList<>();
        List<WebElement> allElements = driver.findElements(By.xpath(txtCategories));
        for(int i=0;i<allElements.size()-1;i++){

        }
        return allCategories;
    }


}


