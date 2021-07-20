package com.example.链表实现栈;

import com.example.数组实现栈.Stack;

/**
 * @author changwei.zheng
 * @date 2020/11/10 19:20
 * @describe
 */
public class MyNodeStack<E> implements Stack<E> {
  private int size = 0;
  private Node<E> headnode;

  public MyNodeStack() {
    // 先初始化
    headnode = new Node(null);
  }

  @Override
  public int getSize() {
    return size;
  }

  @Override
  public boolean isEmpty() {
    return size == 0;
  }

  @Override
  public void push(E e) {
    if (headnode.data == null) {
      headnode.data = e;
    } else {
      Node<E> newNode = new Node<>(e);
      newNode.next = headnode;
      headnode = newNode;
    }
    size++;
  }

  @Override
  public E pop() {
    if (isEmpty()) {
      throw new IllegalArgumentException("Remove failed. Index is illegal.");
    }
    E data = headnode.data;
    headnode = headnode.next;
    size--;
    return data;
  }

  @Override
  public E peek() {
    return headnode.data;
  }


}
