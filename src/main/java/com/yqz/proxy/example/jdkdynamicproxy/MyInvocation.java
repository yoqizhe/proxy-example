package com.yqz.proxy.example.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyInvocation implements InvocationHandler {

    private Intfs target = new TargetWithInterface();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk: do something before method");
        Object result = method.invoke(this.target, args);
        if (result == target) {
            return proxy;
        } else {
            return result;
        }
    }

}
