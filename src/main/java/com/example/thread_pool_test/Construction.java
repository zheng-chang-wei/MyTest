package com.example.thread_pool_test;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author changwei.zheng
 * @date 2021/1/11 16:08
 * @describe
 */
public class Construction {
  public static void main(String[] args) throws InterruptedException {
    ThreadPoolExecutor executor =
        new ThreadPoolExecutor(
            1,
            1,
            1,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<Runnable>(),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());
    executor.prestartAllCoreThreads();
    // Starts a core thread
    executor.prestartCoreThread();
//    executor.allowsCoreThreadTimeOut();
    executor.allowCoreThreadTimeOut(true);
    //    TimeUnit.SECONDS.sleep(2);
    System.out.println(executor.getActiveCount());
    executor.shutdown();
  }
}
