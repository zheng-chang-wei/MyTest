package com.example.leetcode;

import io.swagger.models.auth.In;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author changwei.zheng
 * @date 2021/7/5 15:43
 * @describe 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *     <p>push(x) —— 将元素 x 推入栈中。 pop() —— 删除栈顶的元素。 top() —— 获取栈顶元素。 getMin() —— 检索栈中的最小元素。
 */
public class 最小栈 {

  private static final Integer[][] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
  Integer[][] elementData = null;
  private int size;
  private static final int DEFAULT_CAPACITY = 10;

  public 最小栈() {
    this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
  }

  public static void main(String[] args) {
    最小栈 object = new 最小栈();
    object.push(-2);
    object.push(0);
    object.push(-3);
    System.out.println(object.getMin());
    object.pop();
    System.out.println(object.top());
    System.out.println(object.getMin());
  }

  public void push(int val) {
    ensureCapacityInternal(size + 1);
    Integer[] a = new Integer[2];
    if (size == 0) {
      a[0] = val;
      a[1] = val;
    } else {
      a[0] = val;
      int min = elementData[size - 1][1];
      if (val < min) {
        a[1] = val;
      } else {
        a[1] = min;
      }
    }
    elementData[size++] = a;
  }

  public void pop() {
    if (size > 0) elementData[--size] = null;
  }

  public int top() {
    return elementData[size - 1][0];
  }

  public int getMin() {
    return elementData[size - 1][1];
  }

  private void ensureCapacityInternal(int minCapacity) {
    int newCapacity = 0;
    if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
      newCapacity = DEFAULT_CAPACITY;
      elementData = Arrays.copyOf(elementData, newCapacity);
    } else {
      if (minCapacity > elementData.length) {
        int oldCapacity = elementData.length;
        newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity > Integer.MAX_VALUE) {
          newCapacity = Integer.MAX_VALUE;
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
      }
    }
  }
}
