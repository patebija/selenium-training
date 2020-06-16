package com.qascript.utils.Common;

import java.util.Collections;
import java.util.List;

public class CommonUtils {

    public static Boolean compareList(List<String>list1, List<String> list2){

        Collections.sort(list1);
        Collections.sort(list2);
        boolean isEqual = list1.equals(list2);
        return isEqual;

    }
}
