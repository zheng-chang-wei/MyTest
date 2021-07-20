package com.example.设计模式.观察者模式;

public class Client {
	public static void main(String[] args) {
		//目标对象
		ConcreteSubject subject = new ConcreteSubject();
		
		//创建多个观察者
		ObserverA  obs1 = new ObserverA();
		ObserverA  obs2 = new ObserverA();
		ObserverA  obs3 = new ObserverA();
		
		//将这三个观察者添加到subject对象的观察者队伍中
		subject.addObserver(obs1);
		subject.addObserver(obs2);
		subject.addObserver(obs3);
		
		
		//改变subject的状态
		subject.setState(3000);
		System.out.println("########################");

		
		//改变subject的状态
		subject.setState(30);
		System.out.println("########################");

		
		//改变subject的状态
		subject.setState(99);
		System.out.println("########################");

	}
}

