package com.example.设计模式.观察者模式;

import java.util.Observable;
import java.util.Observer;

/**
 * 观察者模式：观察者 实现
 *
 * @author dengp
 */
public class ObserverA implements Observer {

  @Override
  public void update(Observable o, Object arg) {
    System.out.println(arg);
  }
}
