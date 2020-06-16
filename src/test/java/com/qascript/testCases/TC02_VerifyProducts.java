package com.qascript.testCases;

import com.qascript.pageObjects.HomePage;
import com.qascript.utils.Common.ExcelUtils;
import org.testng.annotations.Test;

import java.util.List;

public class TC02_VerifyProducts {

    @Test
    public void verifyAllCategories(){
        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/data/TestData.xlsx");
        List<String> expectedCategory = excelUtils.readExcelData("Products","Categories");
        List<String> actualCategory = HomePage.getAllCategories();
    }
}
