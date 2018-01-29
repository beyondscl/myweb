package com.bird.util;

import java.util.Random;

/**
 * author: 牛虻.
 * time:2018/1/27
 * email:pettygadfly@gmail.com
 * doc:
 */
public class MathUtil {

    public static int getRom() {
        int max = 9;
        int min = 1;
        Random random = new Random();
        int s = random.nextInt(max) % (max - min + 1) + min;
        return s;
    }
}
