package com.example.数组实现栈;

/**
 * @author changwei.zheng
 * @date 2020/11/10 17:06
 * @describe
 */
public interface Stack<E> {
  int getSize();

  boolean isEmpty();

  /** 入栈 */
  void push(E e);

  /** 出栈 */
  E pop();

  /** 查看栈顶元素 */
  E peek();
}
