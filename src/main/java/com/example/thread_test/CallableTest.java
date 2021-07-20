package com.example.thread_test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @author changwei.zheng
 * @date 2021/1/11 10:50
 * @describe
 */
public class CallableTest {
  public static void main(String[] args) {

    FutureTask<Integer> futureTask = new FutureTask<>(new Task());
    FutureTask<Integer> futureTask2 = new FutureTask<>(new Task());
    new Thread(futureTask, "aaa").start();
    new Thread(futureTask2, "bbb").start();
    System.out.println(2);
    try {
      Integer result = futureTask.get();
      System.out.println(result);
    } catch (InterruptedException e) {
      e.printStackTrace();
    } catch (ExecutionException e) {
      e.printStackTrace();
    }
    System.out.println(3);
  }
}

class Task implements Callable<Integer> {

  @Override
  public Integer call() throws Exception {
    System.out.println(1);
    TimeUnit.SECONDS.sleep(3);
    return 1024;
  }
}
