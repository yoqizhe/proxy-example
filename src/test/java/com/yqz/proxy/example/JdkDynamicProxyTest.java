package com.yqz.proxy.example;

import com.yqz.proxy.example.jdkdynamicproxy.Intfs;
import com.yqz.proxy.example.jdkdynamicproxy.MyInvocation;
import com.yqz.proxy.example.jdkdynamicproxy.TargetWithInterface;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * jdk动态代理测试
 */
public class JdkDynamicProxyTest {

    @Test
    public void test() {
        // 开启后生成的代理类将会保存到项目的根目录下，在junit模式下无效，若要查看生成的class请使用main方法执行
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        // 定义拦截器
        MyInvocation myInvocation = new MyInvocation();
        // 使用运行期间生成代理类创建代理对象
        Intfs jdkDynamicProxy = (Intfs) Proxy.newProxyInstance(TargetWithInterface.class.getClassLoader(), TargetWithInterface.class.getInterfaces(), myInvocation);
        // 代理对象执行方法
        jdkDynamicProxy.fun2().fun1("hello");
    }

    public static void main(String[] args) {
        JdkDynamicProxyTest jdkDynamicProxyTest = new JdkDynamicProxyTest();
        jdkDynamicProxyTest.test();
    }

}
