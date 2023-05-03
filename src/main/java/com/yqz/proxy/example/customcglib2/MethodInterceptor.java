package com.yqz.proxy.example.customcglib2;

import com.yqz.proxy.example.Target;

/**
 * 拦截器
 */
public class MethodInterceptor {

    /**
     * 被代理对象，不需要该对象，因为invokeSuper必须由代理类执行，target对象并没有扩展的方法
     */
    // private Target target = new Target();

    /**
     *
     * @param o
     * @param method 修改为自定义的MyMethod
     * @param objects
     * @return
     */
    public Object intercept(Object o, MethodProxy method, Object[] objects) {
        System.out.println("cglib: do something before method");
        Object result = method.invokeSuper(o, objects);
        return result;
        // 方法执行者是代理对象，this指向就是代理对象，所以不用判断。
//        if (result == target) {
//            return o;
//        } else {
//            return result;
//        }
    }

}
