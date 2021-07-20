package com.example.设计模式.观察者模式;

import java.util.Observable;

/**
 * 观察者模式:目标对象(主体对象 topic)
 * @author dengp
 *
 */
public class ConcreteSubject extends Observable {



	public void setState(int state) {
		setChanged();  //表示目标对象已经做了更改
		notifyObservers(state);  //通知所有的观察者
	}

}
