package org.kevin.common;

import java.util.Random;

/**
 * @author Kevin.Z
 * @version 2021/6/17
 */
public class MyUtils {
    private static final Random GENERATE_RANDOM_INTEGER = new Random(47);

    public static int generateInteger(){
        return GENERATE_RANDOM_INTEGER.nextInt();
    }
    public static int generateIntegerWithBound(int bound){
        return GENERATE_RANDOM_INTEGER.nextInt(bound);
    }

    public static long generateName(){
        return GENERATE_RANDOM_INTEGER.nextLong();
    }
}
