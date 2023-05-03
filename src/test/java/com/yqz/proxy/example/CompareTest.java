package com.yqz.proxy.example;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class CompareTest {

    public static int testCount = 100000000;

    @Test
    public void testJdk() {
        long start = System.currentTimeMillis();

        // 定义拦截器
        TestJdkInvocation testJdkInvocation = new TestJdkInvocation();
        // 使用运行期间生成代理类创建代理对象
        TestInterface jdkDynamicProxy = (TestInterface) Proxy.newProxyInstance(
                CompareTarget.class.getClassLoader(),
                CompareTarget.class.getInterfaces(),
                testJdkInvocation
        );
        // 代理对象执行方法
        int a = 0;
        for (int i = 0; i < testCount; i++) {
            a = jdkDynamicProxy.add(a);
        }

        long end = System.currentTimeMillis();
        System.out.println("jdk: " + (end - start));
    }

    @Test
    public void testCglib() {
        long start = System.currentTimeMillis();

        // 创建增强器
        Enhancer enhancer = new Enhancer();
        // 设置代理类的父类
        enhancer.setSuperclass(CompareTarget.class);
        // 设置拦截器
        enhancer.setCallback(new TestCglibInterceptor());
        // 使用运行期间生成代理类创建代理对象
        CompareTarget cglibDynamicProxy = (CompareTarget) enhancer.create();

        // 代理对象执行方法
        int a = 0;
        for (int i = 0; i < testCount; i++) {
            a = cglibDynamicProxy.add(a);
        }

        long end = System.currentTimeMillis();
        System.out.println("cglib: " + (end - start));
    }


}

interface TestInterface {

    int add(int value);

}

class CompareTarget implements TestInterface {

    @Override
    public int add(int value) {
        int result = value + 1;
        result = result * 2;
        result = result / 2;
        result = result - 1;
        return result;
    }

}

class TestJdkInvocation implements InvocationHandler {

    private CompareTarget target = new CompareTarget();

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return method.invoke(target, args);
    }
}

class TestCglibInterceptor implements MethodInterceptor {

    private CompareTarget target = new CompareTarget();

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        return methodProxy.invoke(target, args);
    }

}