package com.qascript.pageObjects;

import com.qascript.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BaseClass {

    private static String linkLogin = "//span[text()='Login']//ancestor::a[1]";

    public static void clickLogin(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(linkLogin)))).click();

    }


}


