package com.atguigu.proxy;

import com.atguigu.utils.LogUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKProxy {
    public static Object createProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object result = null;
                LogUtils.logBefore(method.getName(), args);
                try {
                    result = method.invoke(target, args);
                    System.out.println("method invoke's returning value is " + result);
                    LogUtils.logAfterReturning(method.getName(), result);
                } catch (Exception e) {
                    LogUtils.logThrowing(method.getName(), e);
                    return new RuntimeException();
                }
                return result;
            }
        });
    }
}
