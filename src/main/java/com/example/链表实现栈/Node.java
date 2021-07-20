package com.example.链表实现栈;

import lombok.Data;

public class Node<E> {
  public E data; // 存放数据
  public Node next; // 指向下一个节点

  public Node() {}

  public Node(E data) {
    this.data = data;
  }
}
