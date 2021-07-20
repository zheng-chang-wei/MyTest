package com.example.cycle_dependence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author changwei.zheng
 * @date 2021/3/2 17:47
 * @describe
 */
@Component
public class Class2 {
  //    private Class1 class2;
  private Class1 class1;

  public Class2(Class1 class1) {}

    public void setClass1(Class1 class1) {
        this.class1 = class1;
    }
}
