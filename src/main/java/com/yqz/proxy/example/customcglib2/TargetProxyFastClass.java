package com.yqz.proxy.example.customcglib2;

/**
 * 方法名称执行器：根据方法名称执行方法
 */
public class TargetProxyFastClass {

    /**
     *
     * @param methodName 方法名称
     * @param obj 执行方法的对象
     * @param args 方法参数
     * @return
     */
    public Object invoke(String methodName, Object obj, Object... args) {
        // 因为需要转型为代理类，所以obj参数不能传被代理对象，因为被代理对象是代理对象的父类，没有扩展方法。
        TargetProxy executor = (TargetProxy) obj;
        switch (methodName) {
            case "fun1": return executor.extend$fun1((String) args[0]);
            case "fun2": return executor.extend$fun2();
            case "fun3": executor.extend$fun3(); return null;
            default: throw new RuntimeException("method name not found");
        }

    }

}
