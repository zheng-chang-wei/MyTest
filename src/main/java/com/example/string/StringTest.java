package com.example.string;

/**
 * @author changwei.zheng
 * @date 2021/1/7 15:53
 * @describe
 */
public class StringTest {
  public static void main(String[] args) {
    //
    // 此时生成了四个对象 常量池中的"1" + 2个堆中的"1" + s3指向的堆中的对象（注此时常量池不会生成"11"）
    String s3 = new String("1") + new String("1");
    // jdk1.7之后，常量池不仅仅可以存储对象，还可以存储对象的引用，会直接将s3的地址存储在常量池
    s3.intern();
    // jdk1.7之后，常量池中的地址其实就是s3的地址
    String s4 = "11";
    // jdk1.7之前false， jdk1.7之后true
    System.out.println(s3 == s4);
  }
}
