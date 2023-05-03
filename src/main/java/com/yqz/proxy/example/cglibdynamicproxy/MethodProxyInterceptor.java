package com.yqz.proxy.example.cglibdynamicproxy;

import com.yqz.proxy.example.Target;
import net.sf.cglib.core.DebuggingClassWriter;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * cglib的拦截器
 */
public class MethodProxyInterceptor implements MethodInterceptor {

    private Target target = new Target();

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib: do something before method");
        Object result = methodProxy.invoke(target, objects);
        if (result == target) {
            return o;
        } else {
            return result;
        }
    }
}
