package com.qascript.testCases;

import com.qascript.BaseClass;
import com.qascript.pageObjects.HomePage;
import com.qascript.pageObjects.LoginPage;
import org.testng.annotations.Test;

public class TC01_VerifyLoginUser extends BaseClass {

@Test
public static void VerifyValidUserLogin(){

    HomePage.clickLogin();
    LoginPage.VerifyLabelMobileNumber("Enter your mobile number");
    LoginPage.VerifyLoginPageHeader("Login");
    LoginPage.EnterMobileNumber("9876543210");
    LoginPage.ClickProceed();
    LoginPage.EnterOtp("5522");
    LoginPage.ClickLogin();

}
}
