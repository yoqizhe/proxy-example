package com.yqz.proxy.example.customcglib2;

import com.yqz.proxy.example.Target;

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

    public String extend$fun1(String param) {
        return super.fun1(param);
    }

    @Override
    public Target fun2() {
        return (Target) methodInterceptor.intercept(this, fun2Method, new Object[]{});
    }

    public Target extend$fun2() {
        return super.fun2();
    }

    @Override
    public void fun3() {
        methodInterceptor.intercept(this, fun3Method, new Object[]{});
    }

    public void extend$fun3() {
        super.fun3();
    }

    static {
        TargetFastClass targetFastClass = new TargetFastClass();
        TargetProxyFastClass targetProxyFastClass = new TargetProxyFastClass();
        fun1Method = new MethodProxy("fun1", targetFastClass, targetProxyFastClass);
        fun2Method = new MethodProxy("fun2", targetFastClass, targetProxyFastClass);
        fun3Method = new MethodProxy("fun3", targetFastClass, targetProxyFastClass);
    }
}
