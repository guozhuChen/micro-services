package com.upin.util;

import java.util.UUID;

/**
 * @Created by Leslie on 2018/7/18.
 */
public class UUIDUtils {
    /**
     *  生成UUID
     * */
    public static String getUUID(){
        return UUID.randomUUID().toString();
    }
}
