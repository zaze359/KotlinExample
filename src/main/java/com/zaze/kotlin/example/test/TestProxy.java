package com.zaze.kotlin.example.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {

    public static void main(String[] args) {


        System.out.println("-----------------------");
        Sub proxy = (Sub) Proxy.newProxyInstance(Sub.class.getClassLoader(), new Class[]{Sub.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("proxy: " + proxy.getClass());
                System.out.println("proxy Interfaces: " + proxy.getClass().getInterfaces()[0]);
                System.out.println("method: " + method);
                System.out.println("args: " + args);
                return proxy;
            }
        });
        proxy.doSome();
    }


    interface Sub {
        void doSome();
    }
}
