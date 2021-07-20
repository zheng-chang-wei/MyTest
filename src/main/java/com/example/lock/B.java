package com.example.lock;

import org.openjdk.jol.info.ClassLayout;

public class B {
    static final A a = new A();
    static volatile int flag = 1;
    public static void main(String[] args) throws InterruptedException {
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
    Thread t2 =
        new Thread() {
          @Override
          public void run() {
            while (flag != 2) {}
            System.out.println(1111);
            synchronized (a) {
              System.out.println("t2");
              System.out.println(ClassLayout.parseInstance(a).toPrintable());
            }
          }
        };

        t1.start();
        Thread.sleep(5000);
        t2.start();
    }
}
class A {
}