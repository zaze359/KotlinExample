package com.zaze.kotlin.example.test;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class Reference {
    public String a = "var";
    public static String sa = "static var";
    public final String b = "val";
    public static final String sb = "static val";
    private static final String sbb = new String("static val");
//
//    static {
//        testConst = new Const();
//    }

    final WeakReference<Object> reference;

    // 当 WeakReference 所引用的对象被回收时 WeakReference会被加入这个队列中
    ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
    Reference(Object obj) {
        this.reference = new WeakReference<>(obj, referenceQueue);
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
    public static void main(String[] args) {
        Object[] obj = new Object[]{new Object()};
        System.out.println("Reference.sb: " + Reference.sb);
        Reference reference = new Reference(obj);
        System.out.println("Reference.a: " + reference.a);
        System.gc();
        System.out.println("obj: " + reference.reference.get()); // 有值
        obj = null;
        System.gc();
        // null
        System.out.println("TestConst.reference 2: " + reference.reference.get());
        // 可以获取 WeakReference
        System.out.println("TestConst.referenceQueue: " + (reference.referenceQueue.poll() == reference.reference));
    }
}

