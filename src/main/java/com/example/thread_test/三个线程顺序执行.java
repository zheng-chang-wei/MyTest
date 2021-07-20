package com.example.thread_test;

import com.example.thread_test.common.Task;
import com.example.thread_test.common.Work;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**

 */
public class 三个线程顺序执行 {

  private static volatile int state = 0;

  public static void main(String[] args) {
    test1();
    test2();
    test3();
    test4();
    test5();
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
              System.out.print(Thread.currentThread().getName() + " ");
              state = 1;
            },
            "1");
    Thread thread2 =
        new Thread(
            () -> {
              while (state != 1) {}
              System.out.print(Thread.currentThread().getName() + " ");
              state = 2;
            },
            "2");
    Thread thread3 =
        new Thread(
            () -> {
              while (state != 2) {}
              System.out.println(Thread.currentThread().getName() + " ");
            },
            "3");
    thread1.start();
    thread2.start();
    thread3.start();
  }

  public static void test3() {
    FutureTask<Integer> futureTask1 = new FutureTask<>(new Task());
    FutureTask<Integer> futureTask2 = new FutureTask<>(new Task(futureTask1));
    FutureTask<Integer> futureTask3 = new FutureTask<>(new Task(futureTask2));
    new Thread(futureTask1, "1").start();
    new Thread(futureTask2, "2").start();
    new Thread(futureTask3, "3").start();
  }

  public static void test4() {

    ReentrantLock lock = new ReentrantLock();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    Thread thread1 =
        new Thread(
            () -> {
              try {
                lock.lock();
                System.out.print(Thread.currentThread().getName() + " ");
                condition2.signal();
                state = 2;
              } finally {
                lock.unlock();
              }
            },
            "1");
    Thread thread2 =
        new Thread(
            () -> {
              try {
                lock.lock();
                while (state != 2) {
                  condition2.await();
                }
                System.out.print(Thread.currentThread().getName() + " ");
                condition3.signal();
                state = 3;
              } catch (InterruptedException e) {
                e.printStackTrace();
              } finally {
                lock.unlock();
              }
            },
            "2");
    Thread thread3 =
        new Thread(
            () -> {
              try {
                lock.lock();
                while (state != 3) {
                  condition3.await();
                }
                System.out.println(Thread.currentThread().getName() + " ");
              } catch (InterruptedException e) {
                e.printStackTrace();
              } finally {
                lock.unlock();
              }
            },
            "3");
    thread1.start();
    thread2.start();
    thread3.start();
  }

  public static void test5() {
    Thread t1 = new Thread(new Work(), "1");
    Thread t2 = new Thread(new Work(), "2");
    Thread t3 = new Thread(new Work(), "3");
    CompletableFuture.runAsync(() -> t1.start())
        .thenRun(() -> t2.start())
        .thenRun(() -> t3.start());
  }
}
