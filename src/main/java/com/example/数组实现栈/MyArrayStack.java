package com.example.数组实现栈;

/**
 * @author changwei.zheng
 * @date 2020/11/10 17:07
 * @describe
 */
public class MyArrayStack<E> implements Stack<E> {
  private static final int DEFAULT_CAPACITY = 10;
  private E[] array = null;

  private int size = 0;

  public MyArrayStack(int capacity) {
    array = (E[]) new Object[capacity];
  }

  public MyArrayStack() {
    array = (E[]) new Object[DEFAULT_CAPACITY];
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return array.length == 0;
  }

  @Override
  public void push(E e) {
    if (size >= array.length) {
      resize();
    }
    array[size] = e;
    size++;
  }

  @Override
  public E pop() {
    if (isEmpty()) {
      throw new IllegalArgumentException("Remove failed. Index is illegal.");
    }
    E data = array[size - 1];
    size--;
    array[size] = null;
    return data;
  }

  @Override
  public E peek() {
    return array[size - 1];
  }

  @Override
  public String toString() {
    StringBuilder res = new StringBuilder();
    res.append("Stack: ");
    res.append('[');
    for (int i = 0; i < array.length; i++) {
      res.append(array[i]);
      if (i != array.length - 1) {
        res.append(", ");
      }
    }
    res.append("] top"); // 表明右侧是栈顶
    return res.toString();
  }

  private void resize() {
    E[] newArray = (E[]) new Object[size * 2];
    for (int i = 0; i < array.length; i++) {
      newArray[i] = array[i];
    }
    array = newArray;
  }
}
