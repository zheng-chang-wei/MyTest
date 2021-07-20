package com.example.list;

import com.example.classic.Father;

import java.util.*;

/**
 * @author changwei.zheng
 * @date 2020/12/23 17:28
 * @describe
 */
public class AllMap {
  public static void main(String[] args) {
    // Map
    Map<Object, Object> hashMap = new HashMap<>();
    Map<Object, Object> hashtable = new Hashtable<>();
    Map<Object, Object> linkedHashMap = new LinkedHashMap<>();
    Map<Object, Object> treeMap = new TreeMap<>();
    Father father = new Father();
    linkedHashMap.put("aaa", 0);
    linkedHashMap.put(father,1);


    Map<Object, Object> synchronizedMap = Collections.synchronizedMap(hashMap);

  }
}
