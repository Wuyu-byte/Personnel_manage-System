package com.xlk.common.util;

import java.util.UUID;

public class EmpUid {
    public static String getID(){
        return UUID.randomUUID().toString().replace("-","").substring(0,20);
    }
}
