package com.qascript.pageObjects;

import com.qascript.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage  {

    private static WebDriver driver;

    private static String btnAddTataAgniLeafTeaPouch500GM = "//div[@id='product - 7211']//span[text()='ADD'][1]";
    private static String txtSearch = "//input[@id='desktop-search']";
    private static String btnCart = "//div[@id='cart-dropdown']";

    public static void clickAddButton(){
        driver.findElement(By.xpath(btnAddTataAgniLeafTeaPouch500GM)).click();
    }

    public static void enterSearch(String strProductName){
        driver.findElement(By.xpath(txtSearch)).sendKeys(strProductName);
    }

    public static void clickCart(){
        driver.findElement(By.xpath(btnCart)).click();
    }
}
