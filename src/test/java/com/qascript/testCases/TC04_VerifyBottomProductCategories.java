package com.qascript.testCases;

import com.qascript.BaseClass;
import com.qascript.pageObjects.HomePage;
import org.testng.annotations.Test;

public class TC04_VerifyBottomProductCategories extends BaseClass {

    @Test
    public void verifyBottomProducts(){
        HomePage.getbottomProduct();
    }

}
