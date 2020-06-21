package com.qascript.pageObjects;

import com.qascript.BaseClass;
import org.openqa.selenium.By;

public class OrderPage extends BaseClass {

    private static String txtPageHeader = "//h2[text()='Place Order']";
    private static String rbPickupStore = "//input[@id='deliveryRadio2']";
    private static String btnNext = "//button[text()=' Next ']";
    private static String btnPlaceOrder = "//button[text()=' Place Order ']";


    public static void verifyPlaceOrderPage(){
        driver.findElement(By.xpath(txtPageHeader)).isDisplayed();
    }

    public static void clickPickupFromStore(){
        driver.findElement(By.xpath(rbPickupStore)).click();
    }

    public static void clickNext(){
        driver.findElement(By.xpath(btnNext)).click();
    }

    public static void clickPlaceOrder(){
        driver.findElement(By.xpath(btnPlaceOrder)).click();
    }

}
