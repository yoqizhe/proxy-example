package com.yqz.proxy.example.customcglib1;

import com.yqz.proxy.example.Target;

/**
 * 生成的代理类
 */
public class TargetProxy extends Target {

    private static MethodProxy fun1Method;

    private static MethodProxy fun2Method;

    private static MethodProxy fun3Method;

    private MethodInterceptor methodInterceptor;

    public TargetProxy(MethodInterceptor methodInterceptor) {
        this.methodInterceptor = methodInterceptor;
    }

    @Override
    public String fun1(String param) {
        return (String) methodInterceptor.intercept(this, fun1Method, new Object[]{param});
    }

    @Override
    public Target fun2() {
        return (Target) methodInterceptor.intercept(this, fun2Method, new Object[]{});
    }

    @Override
    public void fun3() {
        methodInterceptor.intercept(this, fun3Method, new Object[]{});
    }

    static {
        TargetFastClass targetFastClass = new TargetFastClass();
        fun1Method = new MethodProxy("fun1", targetFastClass);
        fun2Method = new MethodProxy("fun2", targetFastClass);
        fun3Method = new MethodProxy("fun3", targetFastClass);
    }
}
