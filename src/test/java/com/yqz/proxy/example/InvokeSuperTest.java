package com.yqz.proxy.example;

import com.yqz.proxy.example.customcglib2.MethodInterceptor;
import com.yqz.proxy.example.customcglib2.TargetProxy;
import org.junit.Test;

/**
 * 演示cglib的methodProxy.invokeSuper的作用
 */
public class InvokeSuperTest {

    @Test
    public void test() {
        // 创建拦截器
        MethodInterceptor methodInterceptor = new MethodInterceptor();
        // 创建代理对象
        TargetProxy targetProxy = new TargetProxy(methodInterceptor);
        targetProxy.fun2().fun1("hello");
    }

}
