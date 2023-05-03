package com.yqz.proxy.example;

import org.junit.Test;

/**
 * 测试被代理类
 */
public class TargetTest {

    @Test
    public void test() {
        Target target = new Target();
        target.fun2().fun1("hello");
    }

}