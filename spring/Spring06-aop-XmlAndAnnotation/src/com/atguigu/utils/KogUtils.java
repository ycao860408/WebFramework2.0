package com.atguigu.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Order(2)
public class KogUtils {
    @Pointcut("execution(* com.atguigu.Service.Calculator.*(..))")
    public static void pointCut(){}

    @Before("pointCut()")
    public static void logBefore(JoinPoint joinPoint) {
        System.out.println("K preAnnouncement! method name: " + joinPoint.getSignature().getName() + " parameters: " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("pointCut()")
    public static void logAfter(JoinPoint joinPoint) {
        System.out.println("K afterAnnouncement! method name: " + joinPoint.getSignature().getName() + " parameters: " + Arrays.toString(joinPoint.getArgs()));
    }
    @AfterReturning(value = "pointCut()", returning = "result")
    public static void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("K afterReturningAnnouncement! method name: " + joinPoint.getSignature().getName() + " parameters: " + Arrays.toString(joinPoint.getArgs()) + " and the result is " + result + ".");
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public static void logThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("K ExceptionAnnouncement! method name: " + joinPoint.getSignature().getName() + " parameters: " + Arrays.toString(joinPoint.getArgs()) + " and the exception is " + e + ".");
    }
}
