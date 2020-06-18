package com.qascript.pageObjects;

import com.qascript.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BaseClass {


    private static String linkLogin = "//span[text()='Login']//ancestor::a[1]";
    private static String linkProfile="//a[@id='profile-drop']";
    private static String linkLogout="//span[text()='Log Out']";
    private static String ddShopByCategory= "//span[text()='Shop by Category']";
    private static String txtCategories = "//a[@id='catTab71-t']";
    private static String txtSubCategories = "//*[@id='catTab71']/a";
    private static WebElement shopByCategory = driver.findElement(By.xpath("(//span[text()='Shop by Category'])[2]"));
    private static String txtSubCategoriesHeader = "//h2[@class='ng-star-inserted']";


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
        List<WebElement> allElementCategories = driver.findElements(By.xpath(txtCategories));
        for(WebElement element:allElementCategories){
            String txtCategory = element.getAttribute("innerHTML");
            allCategories.add(txtCategory);
        }
        return allCategories;
    }

    public static List<String> getAllSubCategories(){
        List<String>allSubCategories = new ArrayList<>();
        List<WebElement> allElementSubCategories;
        List<WebElement> allElementCategories = driver.findElements(By.xpath(txtCategories));
        for(WebElement element:allElementCategories){
            Actions actions = new Actions(driver);
            actions.moveToElement(shopByCategory);
            actions.perform();
            element.click();
            allElementSubCategories = driver.findElements(By.xpath(txtSubCategories));
            for(WebElement elements:allElementSubCategories){
                String txtSubCategory = elements.getAttribute("innerHTML");
                allSubCategories.add(txtSubCategory);
            }
        }
        return allSubCategories;
    }

    public static void validateEachSubCategory(){
        List<WebElement> allElementSubCategories;
        List<WebElement> allElementCategories = driver.findElements(By.xpath(txtCategories));
        for(WebElement element:allElementCategories){
            Actions actions = new Actions(driver);
            actions.moveToElement(shopByCategory);
            actions.perform();
            element.click();
            allElementSubCategories = driver.findElements(By.xpath(txtSubCategories));
            for(WebElement elements:allElementSubCategories){
                String txtCategoryMenu= element.getText();
                String txtSubCategoryMenu = elements.getText();
                elements.click();
                String pageHeader = driver.findElement(By.xpath(txtSubCategoriesHeader)).getText();
                Assert.assertTrue(pageHeader.equals(txtSubCategoryMenu),"Sub-category page header: "+pageHeader+
                        " is not matching with sub-category text: " + txtSubCategoryMenu);
            }
        }

    }



}


