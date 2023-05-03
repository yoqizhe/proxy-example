package com.yqz.proxy.example;

import com.yqz.proxy.example.staticproxy.ExtendStaticProxy;
import com.yqz.proxy.example.staticproxy.StaticProxy;
import org.junit.Test;

/**
 * 静态代理测试
 */
public class StaticProxyTest {

    /**
     * 静态代理-引用方式实现 测试
     * fun1内部调用的fun3不走代理
     */
    @Test
    public void testReference() {
        StaticProxy staticProxy = new StaticProxy();
        staticProxy.fun2().fun1("hello");
    }

    /**
     * 静态代理-继承方式实现 测试
     * fun1内部调用的fun3也走代理
     */
    @Test
    public void testExtend() {
        ExtendStaticProxy staticProxy = new ExtendStaticProxy();
        staticProxy.fun2().fun1("hello");
    }

}