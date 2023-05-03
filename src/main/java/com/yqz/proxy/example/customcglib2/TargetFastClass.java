package com.yqz.proxy.example.customcglib2;

import com.yqz.proxy.example.Target;

/**
 * 方法名称执行器：根据方法名称执行方法
 */
public class TargetFastClass {

    public Object invoke(String methodName, Object obj, Object... args) {
        Target executor = (Target) obj;
        switch (methodName) {
            case "fun1": return executor.fun1((String) args[0]);
            case "fun2": return executor.fun2();
            case "fun3": executor.fun3();
            default: throw new RuntimeException("method name not found");
        }
    }

}
