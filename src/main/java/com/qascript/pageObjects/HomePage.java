package com.qascript.pageObjects;

import com.qascript.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class HomePage extends BaseClass {

    private static String btnAddTataAgniLeafTeaPouch500GM = "//div[@id='product - 7211']//span[text()='ADD'][1]";
    private static String txtSearch = "//input[@id='desktop-search']";
    private static String btnCart = "//div[@id='cart-dropdown']";
    private static String txtProductCategory = "//div[@class='component-cart-dropdown-container nopadding']//div[@class='product-category']/p";

    public static void clickAddButton(){
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0,300)");
        driver.findElement(By.xpath(btnAddTataAgniLeafTeaPouch500GM)).click();
    }

    public static void enterSearch(String strProductName){
        driver.findElement(By.xpath(txtSearch)).sendKeys(strProductName);
        driver.findElement(By.xpath(txtSearch)).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    }

    public static void OpenCart(){
        driver.findElement(By.xpath(btnCart)).click();
    }

    public static void verifyProductNameInCart(String expectedProductName){
        String actualProductName = driver.findElement(By.xpath(txtProductCategory)).getText();
        Assert.assertTrue(actualProductName.equals(expectedProductName),"Actual Product Name: "+
                actualProductName + " not matching with expected Product Name: "+ expectedProductName);
    }
}


