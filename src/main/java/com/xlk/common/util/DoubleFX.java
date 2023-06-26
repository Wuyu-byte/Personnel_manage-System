package com.xlk.common.util;

import java.math.BigDecimal;

public class DoubleFX {
    public static String getDoubleToString (Double numDouble,int size){
        String result="";
        //转换为小数点后2位
        BigDecimal bd=new BigDecimal(numDouble);
        BigDecimal bd1=bd.setScale(size, BigDecimal.ROUND_HALF_UP);
        double d=Double.parseDouble(bd1.toString());
        result=String.valueOf(d);
        return result;
    }
}
