package com.qascript.testCases;

import com.qascript.BaseClass;
import com.qascript.pageObjects.HomePage;
import org.testng.annotations.Test;

public class TC01_Checkout_Product extends BaseClass {

    @Test (priority = 0)
    public static void SelectProductAndCheckout(){
        HomePage.enterSearch("Tata Agni Leaf Tea Pouch");
        HomePage.clickAddButton();
        HomePage.OpenCart();
        HomePage.verifyProductNameInCart("Agni Leaf Tea Pouch");
    }


}
