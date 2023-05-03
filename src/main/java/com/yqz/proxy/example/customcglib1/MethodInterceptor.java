package com.yqz.proxy.example.customcglib1;

import com.yqz.proxy.example.Target;

/**
 * 拦截器
 */
public class MethodInterceptor {

    /**
     * 被代理对象
     */
    private Target target = new Target();

    /**
     *
     * @param o
     * @param method 修改为自定义的MyMethod
     * @param objects
     * @return
     */
    public Object intercept(Object o, MethodProxy method, Object[] objects) {
        System.out.println("cglib: do something before method");
        Object result = method.invoke(target, objects);
        if (result == target) {
            return o;
        } else {
            return result;
        }
    }

}
