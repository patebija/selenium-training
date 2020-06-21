package com.qascript.testCases;

import com.qascript.BaseClass;
import com.qascript.pageObjects.CartPage;
import com.qascript.pageObjects.HomePage;
import com.qascript.pageObjects.LoginPage;
import com.qascript.pageObjects.OrderPage;
import com.qascript.utils.Common.PropertyFileUtils;
import org.apache.commons.math3.geometry.partitioning.BSPTreeVisitor;
import org.testng.annotations.Test;

import java.util.Base64;

public class TC03_VerifyCheckoutProducts extends BaseClass {


    @Test
    public static void CheckoutProduct(){
        HomePage.clickLogin();
        LoginPage.VerifyLabelMobileNumber("Enter your mobile number");
        LoginPage.VerifyLoginPageHeader("Login");
        LoginPage.EnterMobileNumber(PropertyFileUtils.loadUserProperties().getProperty("mobileNumber"));
        LoginPage.ClickProceed();
        LoginPage.EnterOtp(PropertyFileUtils.loadUserProperties().getProperty("otp"));
        LoginPage.ClickLogin();
        HomePage.searchItem("Peanuts");
        HomePage.addProductInCart("Peanuts");
        HomePage.openCart();
        CartPage.checkoutProduct();
        OrderPage.verifyPlaceOrderPage();
        OrderPage.clickPickupFromStore();
        OrderPage.clickNext();
        OrderPage.clickPlaceOrder();

    }
}

