package com.qascript.pageObjects;

import com.qascript.BaseClass;
import org.openqa.selenium.By;

public class CartPage extends BaseClass {

    private static String btnCheckout = "(//button[text()=' CHECKOUT '])[1]";


    public static void checkoutProduct(){
        driver.findElement(By.xpath(btnCheckout)).click();
    }

}
