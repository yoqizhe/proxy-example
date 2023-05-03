package com.yqz.proxy.example.staticproxy;

import com.yqz.proxy.example.Target;

/**
 * 静态代理实现拦截器
 *
 * 缺点：每个方法需要写一样的代码
 */
public class StaticInterceptor {

    private Target target = new Target();

    public String fun1(String param) {
        doSomeThingBefore();
        return target.fun1(param);
    }

    public StaticInterceptor fun2() {
        doSomeThingBefore();
        Target target = this.target.fun2();
        return this;
    }

    public void fun3() {
        doSomeThingBefore();
        this.target.fun3();
    }

    private void doSomeThingBefore() {
        System.out.println("do something before");
    }

    public static void main(String[] args) {
        StaticInterceptor staticInterceptor = new StaticInterceptor();
        staticInterceptor.fun2().fun1("hello");
    }
}
