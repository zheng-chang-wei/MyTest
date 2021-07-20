package com.example.list;

import org.apache.commons.collections.list.SynchronizedList;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author changwei.zheng
 * @date 2020/6/23 18:57
 * @describe
 */
public class Test {
  public static void main(String[] args) {
    List<Object> objects = Collections.synchronizedList(new ArrayList<>());
    objects.add(1);
    objects.get(0);
    Vector vector = new Vector();
    vector.add(1);
    Iterator iterator = vector.iterator();
    while (iterator.hasNext()){
      Object next = iterator.next();
      System.out.println(next);
    }
    List copyOnWriteArrayList = new CopyOnWriteArrayList();
    copyOnWriteArrayList.add(1);
    copyOnWriteArrayList.get(0);
    HashSet<Object> hashSet = new HashSet<>();
    CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
    copyOnWriteArraySet.add(1);


    Map<Object, Object> treeMap = new TreeMap<>();

    Map<Object, Object> hashtable = new Hashtable<>();
    Map<String, String> map = new ConcurrentHashMap<>();
    map.put("1", "1");
    Map<Object, Object> synchronizedMap = Collections.synchronizedMap(new HashMap<>());
    synchronizedMap.put("1", "1");

    new Hashtable<>();

    ThreadLocal<Object> tl = new ThreadLocal<>();
    tl.set("");
    tl.get();
    tl.remove();
  }
}
