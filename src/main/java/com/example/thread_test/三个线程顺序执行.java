package com.example.thread_test;

import com.example.thread_test.common.Work;

/**
 * @author zcw @Description:
 * @date 2021-07-2023:42
 */
public class 三个线程顺序执行 {

  private static volatile int state = 0;

  public static void main(String[] args) {
    test1();
    System.out.println();
    test2();
  }

  public static void test1() {
    Thread thread1 = new Thread(new Work(null), "1");
    Thread thread2 = new Thread(new Work(thread1), "2");
    Thread thread3 = new Thread(new Work(thread2), "3");
    thread1.start();
    thread2.start();
    thread3.start();
  }

  public static void test2() {
    Thread thread1 =
        new Thread(
            () -> {
              System.out.print(Thread.currentThread().getName()+" ");
              state = 1;
            },
            "1");
    Thread thread2 =
        new Thread(
            () -> {
              while (state != 1) {}
              System.out.print(Thread.currentThread().getName()+" ");
              state = 2;
            },
            "2");
    Thread thread3 =
        new Thread(
            () -> {
              while (state != 2) {}
              System.out.println(Thread.currentThread().getName()+" ");
            },
            "3");
    thread1.start();
    thread2.start();
    thread3.start();
  }
}
