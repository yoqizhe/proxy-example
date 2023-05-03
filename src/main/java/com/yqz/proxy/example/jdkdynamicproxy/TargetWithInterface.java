package com.yqz.proxy.example.jdkdynamicproxy;

public class TargetWithInterface implements Intfs {

    @Override
    public String fun1(String param) {
        System.out.println("fun1:" + this);
        this.fun3();
        return param;
    }

    @Override
    public Intfs fun2() {
        System.out.println("fun2:" + this);
        return this;
    }

    public void fun3() {
        System.out.println("fun3:" + this);
    }

}
