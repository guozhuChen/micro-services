package com.upin.util;

import java.util.regex.Pattern;

/**
 * @Created by Leslie on 2018/7/20.
 */
public class DefaultMatcherUtils {
    public static final String REGEX_PHONE = "^((17[0-9])|(16[0-9])|(14[0-9])|(13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";
    public static final String REGEX_EMAIL = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";

    public static boolean isPhone(String phone) {
        return Pattern.matches(REGEX_PHONE, phone);
    }

    public static boolean isEmail(String email){
        return Pattern.matches(REGEX_EMAIL, email);
    }
}
