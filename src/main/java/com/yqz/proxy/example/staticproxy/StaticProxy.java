package com.yqz.proxy.example.staticproxy;

import com.yqz.proxy.example.Target;

/**
 * 静态代理实现类
 */
public class StaticProxy {

    /**
     * 被代理对象
     */
    private Target target = new Target();

    public String fun1(String param) {
        System.out.println("do something before fun1");
        return target.fun1(param);
    }

    public StaticProxy fun2() {
        System.out.println("do something before fun2");
        target.fun2();
        return this;
    }

    public void fun3() {
        System.out.println("do something before fun3");
        target.fun3();
    }

}
