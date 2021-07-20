package com.example.cycle_dependence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author changwei.zheng
 * @date 2021/3/2 17:47
 * @describe
 */
@Component
public class Class1 {
  //    @Autowired private Class2 class2;
  private Class2 class2;

//  public Class1(Class2 class2) {}

    public void setClass2(Class2 class2) {
        this.class2 = class2;
    }
}
