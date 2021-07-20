package com.example.thread_test;

import com.example.thread_test.common.Task;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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


