package com.yqz.proxy.example.staticproxy;

import com.yqz.proxy.example.Target;

/**
 * 静态代理实现类
 */
public class ExtendStaticProxy extends Target{

    public String fun1(String param) {
        System.out.println("do something before fun1");
        return super.fun1(param);
    }

    public ExtendStaticProxy fun2() {
        System.out.println("do something before fun2");
        super.fun2();
        return this;
    }

    public void fun3() {
        System.out.println("do something before fun3");
        super.fun3();
    }

}
