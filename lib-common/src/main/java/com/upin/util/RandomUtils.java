package com.upin.util;

/**
 * @Created by Leslie on 2018/7/18.
 */
public class RandomUtils {
    /***
     *  6位随机数
     */
    public static String randomNumSix() {
        int count = 6;
        char start = '0';
        char end = '9';
        java.util.Random rnd = new java.util.Random();
        char[] result = new char[count];
        int len = end - start + 1;
        while (count-- > 0) {
            result[count] = (char) (rnd.nextInt(len) + start);
        }
        return new String(result);
    }


    public static String buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return String.valueOf(random * num);
    }
}
