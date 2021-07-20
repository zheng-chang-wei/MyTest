package com.example.threadLocal;

import java.util.concurrent.TimeUnit;

/**
 * @author changwei.zheng
 * @date 2021/2/22 18:47
 * @describe
 */
public class ThreadLocalTest {
  static ThreadLocal threadLocal1 = new ThreadLocal();
  static ThreadLocal threadLocal2 = new ThreadLocal();

  public static void main(String[] args) throws InterruptedException {
    threadLocal1.set(11);
    threadLocal1.set(22);
    Object o1= threadLocal1.get();
    System.out.println(o1);
    threadLocal1=null;
    System.gc();
    TimeUnit.SECONDS.sleep(3);
    Object o2 = threadLocal1.get();

    System.out.println(o2);
    threadLocal1.remove();
  }
}
