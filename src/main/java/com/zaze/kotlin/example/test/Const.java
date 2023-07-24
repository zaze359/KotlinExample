package com.zaze.kotlin.example.test;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class Const {
    public String a = "var";
    public static String sa = "static var";
    public final String b = "val";
    public static final String sb = "static val";
    private static final String sbb = new String("static val");
//
//    static {
//        testConst = new Const();
//    }

    private final Object o;
    Const(Object o) {
        this.o = o;
    }

    static {
        System.out.println("init");
    }

    public void aa() {
        System.out.println("a: " + a);
        System.out.println("sa: " + sa);
        System.out.println("b: " + b);
        System.out.println("sb: " + sb);
        System.out.println("sbb: " + sbb);
    }

}
