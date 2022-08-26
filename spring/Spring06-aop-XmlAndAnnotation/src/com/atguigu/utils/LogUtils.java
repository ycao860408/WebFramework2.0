package com.atguigu.utils;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Arrays;

@Component
@Aspect
@Order(1)
public class LogUtils {

    @Pointcut("execution(* com.atguigu.Service.Calculator.*(..))")
    public static void pointCut(){}

    @Before("pointCut()")
    public static void logBefore(JoinPoint joinPoint) {
        System.out.println("L preAnnouncement! method name: " + joinPoint.getSignature().getName() + " parameters: " + Arrays.toString(joinPoint.getArgs()));
    }

    @After("pointCut()")
    public static void logAfter(JoinPoint joinPoint) {
        System.out.println("L afterAnnouncement! method name: " + joinPoint.getSignature().getName() + " parameters: " + Arrays.toString(joinPoint.getArgs()));
    }
    @AfterReturning(value = "pointCut()", returning = "result")
    public static void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("L afterReturningAnnouncement! method name: " + joinPoint.getSignature().getName() + " parameters: " + Arrays.toString(joinPoint.getArgs()) + " and the result is " + result + ".");
    }

    @AfterThrowing(value = "pointCut()", throwing = "e")
    public static void logThrowing(JoinPoint joinPoint, Exception e) {
        System.out.println("L ExceptionAnnouncement! method name: " + joinPoint.getSignature().getName() + " parameters: " + Arrays.toString(joinPoint.getArgs()) + " and the exception is " + e + ".");
    }

    /*@Around("execution(* com.atguigu.Service.Calculator.*(..))")
    public static Object logAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        Object result = null;
        try{
            System.out.println("preAnnouncement!");
            try{
                System.out.println("target method!");
                Object[] args = proceedingJoinPoint.getArgs();
                if (args!= null && args.length != 0) {
                    result = proceedingJoinPoint.proceed(args);
                } else {
                    result = proceedingJoinPoint.proceed();
                }
            }finally {
                System.out.println("postAnnouncement!");
            }
            System.out.println("returning Announcement!");
        } catch (Exception e){
            System.out.println("Exception Announcement!");
            throw new RuntimeException(e);
        }
        return result;
    }
*/
}
