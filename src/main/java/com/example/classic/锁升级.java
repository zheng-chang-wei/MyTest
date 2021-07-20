package com.example.classic;

import org.openjdk.jol.info.ClassLayout;

public class 锁升级 {
    static final Object a = new Object();

    static volatile int flag = 1;
    public static void main(String[] args) throws InterruptedException {
       int [] b={1,2,3,4,5,6,7,8,9,0};
        System.out.println(ClassLayout.parseInstance(b).toPrintable());
        Thread t1 = new Thread(){
            @Override
            public void run() {
                synchronized (a){
                    System.out.println("t1");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                }
                flag = 2;
            }
        };
        Thread t2 = new Thread(){
            @Override
            public void run() {
                while (flag!=2) {
                }
                synchronized (a){
                    System.out.println("t2");
                    System.out.println(ClassLayout.parseInstance(a).toPrintable());
                }
            }
        };

        t1.start();
        Thread.sleep(100);
//        t2.start();
    }
}
