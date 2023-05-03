package com.yqz.proxy.example;

/**
 * 被代理类
 */
public class Target {

    public String fun1(String param) {
        System.out.println("fun1:" + this.toString());
        // 测试代理类测试内部调用，fun3会走代理吗？
        this.fun3();
        return param;
    }

    public Target fun2() {
        System.out.println("fun2:" + this);
        // 测试代理类的链式调用，返回的是代理还是这个对象？
        return this;
    }

    public void fun3() {
        System.out.println("fun3:" + this);
    }

}
