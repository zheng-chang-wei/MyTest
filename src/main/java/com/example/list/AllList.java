package com.example.list;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author changwei.zheng
 * @date 2020/12/23 17:19
 * @describe
 */
public class AllList {
  public static void main(String[] args) {
    //Iterable---->Collection---->List
      List<Object> objects = new ArrayList<>();
      List<Object> linkedList = new LinkedList<>();
      linkedList.remove(0);
      List<Object> vector = new Vector<>();
      List<Object> synchronizedArrayList = Collections.synchronizedList(objects);
      List<Object> synchronizedLinkedList = Collections.synchronizedList(linkedList);

      List<Object> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
  }
}
