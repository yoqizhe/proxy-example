package com.yqz.proxy.example;

import com.yqz.proxy.example.cglibdynamicproxy.MethodProxyInterceptor;
import com.yqz.proxy.example.cglibdynamicproxy.MethodProxySuperInterceptor;
import com.yqz.proxy.example.cglibdynamicproxy.MyMethodInterceptor;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import org.junit.Test;

import java.util.stream.Stream;

/**
 * cglib动态代理测试
 */
public class CglibDynamicProxyTest {

    /**
     * method.invoke测试
     */
    @Test
    public void testMethodInvoke() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./");

        // 创建增强器
        Enhancer enhancer = new Enhancer();
        // 设置代理类的父类
        enhancer.setSuperclass(Target.class);
        // 设置拦截器
        enhancer.setCallback(new MyMethodInterceptor());
        // 使用运行期间生成代理类创建代理对象
        Target cglibDynamicProxy = (Target) enhancer.create();
        // 代理对象执行方法
        cglibDynamicProxy.fun2().fun1("hello");
    }

    /**
     * methodProxy.invoke测试
     */
    @Test
    public void testMethodProxyInvoke() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./");

        // 创建增强器
        Enhancer enhancer = new Enhancer();
        // 设置代理类的父类
        enhancer.setSuperclass(Target.class);
        // 设置拦截器
        enhancer.setCallback(new MethodProxyInterceptor());
        // 使用运行期间生成代理类创建代理对象
        Target cglibDynamicProxy = (Target) enhancer.create();
        // 代理对象执行方法
        cglibDynamicProxy.fun2().fun1("hello");
    }

    /**
     * methodProxy.invokeSuper测试
     */
    @Test
    public void testMethodProxyInvokeSuper() {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./");

        // 创建增强器
        Enhancer enhancer = new Enhancer();
        // 设置代理类的父类
        enhancer.setSuperclass(Target.class);
        // 设置拦截器
        enhancer.setCallback(new MethodProxySuperInterceptor());
        // 使用运行期间生成代理类创建代理对象
        Target cglibDynamicProxy = (Target) enhancer.create();
        // 代理对象执行方法
        cglibDynamicProxy.fun2().fun1("hello");
    }

    public static void main(String[] args) {
        CglibDynamicProxyTest cglibDynamicProxyTest = new CglibDynamicProxyTest();
        cglibDynamicProxyTest.testMethodProxyInvokeSuper();
    }

}
