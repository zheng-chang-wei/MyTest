package com.example.thread_pool_test;

import java.util.concurrent.*;

/**
 * 第四种获取 / 使用 Java多线程的方式，通过线程池
 *
 * @author: 陌溪
 * @create: 2020-03-17-15:59
 */
public class MyThreadPoolDemo {
  public static void main(String[] args) {

    ExecutorService threadPool =
        new ThreadPoolExecutor(
            3,
            6,
            1,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(3),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    // 模拟10个用户来办理业务，每个用户就是一个来自外部请求线程
    try {

      for (int i = 0; i < 10; i++) {
        final int tempInt = i;
        threadPool.execute(
            () -> {
              try {
                TimeUnit.SECONDS.sleep(20);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              System.out.println(Thread.currentThread().getName() + "\t 给用户:" + tempInt + " 办理业务");
            });
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      threadPool.shutdown();
    }
  }
}
