package com.example.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author changwei.zheng
 * @date 2021/7/16 11:56
 * @describe
 */
public class TestLockSupport {
  public static void main(String[] args) {
      LockSupport.park();
      LockSupport.parkNanos(111);
  }
}
