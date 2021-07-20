package com.example.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class ProxyFactory implements MethodInterceptor {

	private Object target;

	public ProxyFactory(Object target) {
		this.target = target;
	}

	public Object getProxyInstance() {
		// 1.创建一个工具类
		Enhancer enhancer = new Enhancer();
		// 2.设置父类对象
		enhancer.setSuperclass(target.getClass());
		// 3.设置回调函数
		enhancer.setCallback(this);
		// 4.创建子类对象，即代理对象
		return enhancer.create();
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		System.out.println("唱歌前准备");
		Object value = method.invoke(target, args);
		System.out.println("善后工作");
		return value;
	}

}
