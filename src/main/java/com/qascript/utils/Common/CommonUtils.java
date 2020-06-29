package com.qascript.utils.Common;

import com.qascript.BaseClass;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CommonUtils extends BaseClass {

    public static Boolean compareList(List<String>list1, List<String> list2){

        Collections.sort(list1);
        Collections.sort(list2);
        boolean isEqual = list1.equals(list2);
        return isEqual;

    }

    public static void captureScreenshot(String strFile){
        try{
            String screenshotsFolderName = "screenshots";
            String currentTimeStamp = getCurrentTimeStamp("ddMMMYYYY_HHmmss");
            String fileName = screenshotsFolderName + "/" + strFile + "_" + currentTimeStamp + ".jpg";
            TakesScreenshot screenshot = ((TakesScreenshot) driver);
            File scrFile = screenshot.getScreenshotAs(OutputType.FILE);
            File destFile = new File(fileName);
            FileUtils.copyFile(scrFile,destFile);
        }
        catch (Exception e){

        }
    }

    public static String getCurrentTimeStamp(String strDateFormat){
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        return sdf.format(cal.getTime());

    }

    public static Integer generateNumbers(){
        // create instance of Random class
        Random rand = new Random();

        // Generate random integers in range 0 to 999
        int randNum = rand.nextInt(100000);

        return randNum;
    }
}
