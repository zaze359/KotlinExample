package com.zaze.kotlin.example.test;

class Work {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void main(String[] args) {
        final Work work = new Work();
//        new Thread(work::doFirst).start();
//        new Thread(work::doSecond).start();
    }

    public void doFirst() {
        // 先锁 lock1，在锁lock2
        synchronized (lock1) {
            System.out.println("doFirst lock1");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock2) {
                System.out.println("doFirst lock2");
            }
        }
    }

    public void doSecond() {
        // 先锁 lock2，在锁lock1
        synchronized (lock2) {
            System.out.println("doSecond lock2");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (lock1) {
                System.out.println("doSecond lock1");
            }
        }
    }
}
