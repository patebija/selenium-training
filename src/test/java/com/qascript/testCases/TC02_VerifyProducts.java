package com.qascript.testCases;

import com.qascript.BaseClass;
import com.qascript.pageObjects.HomePage;
import com.qascript.utils.Common.CommonUtils;
import com.qascript.utils.Common.ExcelUtils;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

public class TC02_VerifyProducts extends BaseClass {



    @Test
    public void verifyAllCategories(){
        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/data/TestData.xlsx");
        List<String> expectedCategory = excelUtils.readExcelData("Categories","Category");
        List<String> actualCategory = HomePage.getAllCategories();
        boolean match = CommonUtils.compareList(expectedCategory,actualCategory);
        Assert.assertTrue(match,"Expected product categories: " + expectedCategory +
                " don't match with actual product categories: "+actualCategory);
    }

    @Test
    public void verifyAllSubCategories() {
        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/data/TestData.xlsx");
        List<String> expectedSubCategory = excelUtils.readExcelData("SubCategories", "SubCategory");
        List<String> actualSubCategory = HomePage.getAllSubCategories();
        boolean match = CommonUtils.compareList(expectedSubCategory, actualSubCategory);
        Assert.assertTrue(match, "Expected product subcategories: " + expectedSubCategory +
                " don't match with actual product subcategories: " + actualSubCategory);

    }
}
