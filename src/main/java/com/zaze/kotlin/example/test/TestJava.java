package com.zaze.kotlin.example.test;

import java.util.Deque;
import java.util.LinkedList;

public class TestJava {


    public static void main(String[] args) {
//        int a = 0;
//        new Runnable() {
//            @Override
//            public void run() {
//                a = 3; // error
//            }
//        };
//        System.out.println(factorial(4));
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) return 1;
//        int value = 1;
//        for (int i = 1; i <= n; i++) {
//            value = value * i;
//        }
//        return value;
        return n * factorial(n - 1);
    }
}
