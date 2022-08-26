package com.atguigu.utils;

import java.util.Arrays;

public class LogUtils {
    public static void logBefore(String method, Object... args) {
        System.out.println("Method name is " + method + ", parameters are " + Arrays.toString(args));
    }

    public static void logAfterReturning(String method, Object args) {
        System.out.println("Method name is " + method + ", the result is " + args);
    }

    public static void logThrowing(String method, Exception e) {
        System.out.println("Method name is " + method + ", and the exception is " + e);
    }
}
