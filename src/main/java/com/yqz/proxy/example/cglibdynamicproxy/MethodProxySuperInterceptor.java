package com.yqz.proxy.example.cglibdynamicproxy;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib的拦截器
 */
public class MethodProxySuperInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        // 发现多次调用，输出进入拦截器的前一个栈，System.out.println(this)发现隐式调用toString和hashCode
        // 而invokeSuper在方法内部调用公共方法也会走代理
        showBeforeStack();

        System.out.println("cglib: do something before method");
        Object result = methodProxy.invokeSuper(o, objects);
        return result;
    }

    /**
     * 查看进入方法的前一个栈
     */
    private void showBeforeStack() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 0; i < stackTrace.length; i++) {
            if (i > 0 && stackTrace[i - 1].toString().lastIndexOf("MethodProxySuperInterceptor.intercept") != -1) {
                System.out.println("before stack:" + stackTrace[i]);
                break;
            }
        }
    }

}
