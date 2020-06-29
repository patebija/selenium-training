package com.qascript.pageObjects;

import com.qascript.BaseClass;
import com.qascript.utils.Common.CommonUtils;
import org.openqa.selenium.By;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

public class LoginPage extends BaseClass {

    public static String txtboxMobileNumber = "//*[@id='phone']";
    public static String btnProceed = "//button[text()=' Proceed ']";
    public static String btnHome = "//*[text()='Home']//ancestor::button[1]";
    public static String txtLogin = "//h3[text()='Login']";
    public static String lblMobileNumber = "//label[text()='Enter your mobile number']";
    public static String txtboxOtp1 = "//input[@class='form-control'][1]";
    public static String txtboxOtp2 = "//input[@class='form-control'][2]";
    public static String txtboxOtp3 = "//input[@class='form-control'][3]";
    public static String txtboxOtp4 = "//input[@class='form-control'][4]";
    public static String btnLogin = "//button[text()=' Login ']";
    public static String errLogin = "//*[text()='Enter a valid mobile number']";


    public static void EnterMobileNumber(String strMobileNumber){
        driver.findElement(By.xpath(txtboxMobileNumber)).clear();
        driver.findElement(By.xpath(txtboxMobileNumber)).sendKeys(strMobileNumber);

    }

    public static void ClickProceed(){
        driver.findElement(By.xpath(btnProceed)).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static void ClickHome(){
        driver.findElement(By.xpath(btnHome)).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public static void ClickLogin(){
        driver.findElement(By.xpath(btnLogin)).click();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    public static void VerifyLoginPageHeader(String txtHeader){
        String actualHeader = driver.findElement(By.xpath(txtLogin)).getText();
        Assert.assertTrue(txtHeader.equals(actualHeader),"Expected header" +
                txtHeader + "not matching with actual header" + actualHeader);

    }

    public static void VerifyLabelMobileNumber(String strMobileNumberLabel){
        String actualLabel = driver.findElement(By.xpath(lblMobileNumber)).getText();
        Assert.assertTrue(strMobileNumberLabel.equals(actualLabel),"Expected header" +
                strMobileNumberLabel + "not matching with actual header" + actualLabel);
    }
    public static void EnterOtp(String txtOTP){
        String OTP1 = txtOTP.substring(0,1);
        String OTP2 = txtOTP.substring(1,2);
        String OTP3 = txtOTP.substring(2,3);
        String OTP4 = txtOTP.substring(3,4);
        driver.findElement(By.xpath(txtboxOtp1)).sendKeys(OTP1);
        driver.findElement(By.xpath(txtboxOtp2)).sendKeys(OTP2);
        driver.findElement(By.xpath(txtboxOtp3)).sendKeys(OTP3);
        driver.findElement(By.xpath(txtboxOtp4)).sendKeys(OTP4);
    }

    public static void VerifyErrorMessage(String expectedMessage) {
        String actualMessage = driver.findElement(By.xpath(errLogin)).getText();
        Assert.assertTrue(actualMessage.equals(expectedMessage),"Expected error message: " +
                expectedMessage + "doesn't match with Actual error message: "+ actualMessage);

    }


}
