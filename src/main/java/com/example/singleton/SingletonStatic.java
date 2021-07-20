package com.example.singleton;

public class SingletonStatic {

	private static class Singleton {

		public static SingletonStatic singleton = new SingletonStatic();
	}

	private SingletonStatic() {
	}

	public static SingletonStatic getSingleton() {
		return Singleton.singleton;
	}

}
