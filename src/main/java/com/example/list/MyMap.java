package com.example.list;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MyMap {

  public static void main(String[] args) {
      ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
      concurrentHashMap.put("","");
      HashMap<Test, Object> map = new HashMap<>();
    for (int i = 0; i < 20; i++) {
        Test test = new Test();
        map.put(test,i);
    }

  }
}
