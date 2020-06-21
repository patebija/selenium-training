package com.qascript.pageObjects;

import com.qascript.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends BaseClass {


    private static String linkLogin = "//span[text()='Login']//ancestor::a[1]";
    private static String linkProfile="//a[@id='profile-drop']";
    private static String linkLogout="//span[text()='Log Out']";
    private static String ddShopByCategory= "//span[text()='Shop by Category']";
    private static String txtCategories = "//a[@id='catTab71-t']";
    private static String txtSubCategories = "//*[@id='catTab71']/a";
    private static String txtSubCategoriesHeader = "//h2[@class='ng-star-inserted']";
    private static String txtbxSearch = "//input[@placeholder='Search our products']";
    private static String classProductTitle = "//div[@class='str-product-title']";
    private static String btnAddProduct = "(//p[text()='ADD'])[1]";
    private static String iconCart = "//i[text()='shopping_cart']";
    private static String msgOrderSuccess = "//i[@class='material-icons']//following-sibling::p";

    private static WebElement shopByCategory = driver.findElement(By.xpath("(//span[text()='Shop by Category'])[2]"));


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

    /**
     * Get text of all categories and store it in a list
     * @return returns the list of text of all categories
     */
    public static List<String> getAllCategories(){
        List<String>allCategories = new ArrayList<>();
        List<WebElement> allElementCategories = driver.findElements(By.xpath(txtCategories));
        for(WebElement element:allElementCategories){
            String txtCategory = element.getAttribute("innerHTML");
            allCategories.add(txtCategory);
        }
        return allCategories;
    }

    /**
     * Iterate through each category and click on each category
     * Get text of all subcategories and store in a list
     * @return returns the list of text of all sub-categories
     */
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


    /**
     * Iterate through each category and click on each sub-category
     * Compare the page header text for each sub-category and compare the expected text
     */
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
                if(txtSubCategoryMenu.equals("All")){
                    Assert.assertTrue(txtCategoryMenu.equals(pageHeader),"Sub-category page header: "+pageHeader+
                            " is not matching with expected text : " + txtCategoryMenu);
                }
                else {
                    Assert.assertTrue(pageHeader.equals(txtSubCategoryMenu), "Sub-category page header: " + pageHeader +
                            " is not matching with expected text: " + txtSubCategoryMenu);
                }
//                JavascriptExecutor js = (JavascriptExecutor)driver;
//                js.executeScript("arguments[0].scrollIntoView(true);", element);
                driver.getPageSource();
            }
        }

    }

    public static void searchItem(String item){
        driver.findElement(By.xpath(txtbxSearch)).sendKeys(item);
        driver.findElement(By.xpath(txtbxSearch)).sendKeys(Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }

    public static void addProductInCart(String title){
        List<WebElement> allProducts = driver.findElements(By.xpath(classProductTitle));
        for(WebElement element:allProducts){
            String txtProduct = element.getText();
            if(txtProduct.equals(title)){
                element.click();
                driver.findElement(By.xpath(btnAddProduct)).click();
            }

        }
    }

    public static void openCart(){
        driver.findElement(By.xpath(iconCart)).click();

    }




}


