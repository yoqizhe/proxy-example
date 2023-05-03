package com.yqz.proxy.example.customcglib2;

/**
 * 用来替代java.lang.reflect.Method类
 */
public class MethodProxy {

    /**
     * 被代理的方法名称
     */
    private String methodName;

    /**
     * 索引到目标类对应方法
     */
    private TargetFastClass fastClass;

    /**
     * 索引到代理类，执行父类方法
     */
    private TargetProxyFastClass proxyFastClass;

    public MethodProxy(String methodName, TargetFastClass fastClass, TargetProxyFastClass proxyFastClass) {
        this.methodName = methodName;
        this.fastClass = fastClass;
        this.proxyFastClass = proxyFastClass;
    }

    public Object invoke(Object obj, Object... args) {
        // 目标类执行方法
        return fastClass.invoke(methodName, obj, args);
    }

    public Object invokeSuper(Object obj, Object... args) {
        // 调用扩展方法
        return proxyFastClass.invoke(methodName, obj, args);
    }

}
