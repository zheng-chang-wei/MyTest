package com.example.list;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author changwei.zheng
 * @date 2020/12/23 17:23
 * @describe
 */
public class AllSet {
  public static void main(String[] args) {
    //Iterable-----Collection-----Set
      Set<Object> hashSet = new HashSet<>();
      Set<Object> treeSet = new TreeSet<>();//排序
      Set<Object> linkedHashSet = new LinkedHashSet<>();//有序
      Set<Object> synchronizedSet = Collections.synchronizedSet(hashSet);
      Set<Object> copyOnWriteArraySet = new CopyOnWriteArraySet<>();
  }
}
