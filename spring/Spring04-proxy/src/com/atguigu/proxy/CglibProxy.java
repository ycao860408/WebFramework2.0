package com.atguigu.proxy;

import com.atguigu.utils.LogUtils;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibProxy {
    public static Object createProxy(Object target) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                Object result = null;
                LogUtils.logBefore(method.getName(), objects);
                try {
                    result = method.invoke(target, objects);
                    System.out.println("The result of the method.invoke() is " + result);
                    LogUtils.logAfterReturning(method.getName(), result);
                } catch(Exception e) {
                    LogUtils.logThrowing(method.getName(), e);
                    throw new RuntimeException();
                }
                return result;
            }
        });
        Object result = enhancer.create();
        return result;
    }
}
