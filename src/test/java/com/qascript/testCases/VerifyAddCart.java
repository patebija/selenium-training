package com.qascript.testCases;

import com.qascript.BaseClass;
import com.qascript.pageObjects.HomePage;
import org.testng.annotations.Test;

public class VerifyAddCart extends BaseClass {

    @Test
    public static void AddProductCart(){
        HomePage.enterSearch("Tata Agni Leaf Tea Pouch");
        HomePage.clickAddButton();
        HomePage.clickCart();
    }
}
