package com.qascript.testCases;

import com.qascript.BaseClass;
import com.qascript.pageObjects.HomePage;
import com.qascript.pageObjects.LoginPage;
import com.qascript.utils.Common.PropertyFileUtils;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TC01_VerifyLoginUser extends BaseClass {

@Test(priority = 0)
public static void VerifyValidUserLogin(){

    HomePage.clickLogin();
    LoginPage.VerifyLabelMobileNumber("Enter your mobile number");
    LoginPage.VerifyLoginPageHeader("Login");
    LoginPage.EnterMobileNumber(PropertyFileUtils.loadUserProperties().getProperty("mobileNumber"));
    LoginPage.ClickProceed();
    LoginPage.EnterOtp(PropertyFileUtils.loadUserProperties().getProperty("otp"));
    LoginPage.ClickLogin();
    HomePage.verifyHomePageDisplayed();
    HomePage.clickLogout();

}

@Test(priority = 1)
public static void VerifyInvalidUserLogin(){

    HomePage.clickLogin();
    LoginPage.EnterMobileNumber("9389923939293293");
    LoginPage.ClickProceed();
    LoginPage.VerifyErrorMessage("Enter a valid mobile number");

  }

}

