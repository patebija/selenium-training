package com.qascript.testCases;

import com.aventstack.extentreports.Status;
import com.qascript.BaseClass;
import com.qascript.pageObjects.HomePage;
import org.testng.annotations.Test;

public class TC04_VerifyBottomProductCategories extends BaseClass {

    @Test
    public void verifyBottomProducts(){
        test = extent.createTest("Verify Bottom Products");
        test.log(Status.INFO,"Starting the test");
        HomePage.getbottomProduct();


    }

}
