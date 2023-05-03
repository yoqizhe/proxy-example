package com.yqz.proxy.example.customcglib1;

/**
 * 用来替代java.lang.reflect.Method类
 */
public class MethodProxy {

    /**
     * 被代理的方法名称
     */
    private String methodName;

    /**
     * 方法名称执行器
     */
    private TargetFastClass fastClass;

    public MethodProxy(String methodName, TargetFastClass fastClass) {
        this.methodName = methodName;
        this.fastClass = fastClass;
    }

    public Object invoke(Object obj, Object... args) {
        return fastClass.invoke(methodName, obj, args);
    }

}
