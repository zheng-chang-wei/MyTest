package com.example.proxy;

import com.example.web.service.impl.TestService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 调用处理器实现类
 * 每次生成动态代理类对象时都需要指定一个实现了该接口的调用处理器对象
 */
public class InvocationHandlerImpl implements InvocationHandler {

	/**
	 * 这个就是我们要代理的真实对象
	 */
	private TestService subject;

	/**
	 * 构造方法，给我们要代理的真实对象赋初值
	 * 
	 * @param subject
	 */
	public InvocationHandlerImpl(TestService subject) {
		this.subject = subject;
	}

	public TestService getProxyInstance() {
		Class<? extends Object> clazz = this.subject.getClass();
		/**
		 * 该方法用于为指定类装载器、一组接口及调用处理器生成动态代理类实例
		 */
		return (TestService) Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), this);
	}

	/**
	 * 该方法负责集中处理动态代理类上的所有方法调用。
	 * 调用处理器根据这三个参数进行预处理或分派到委托类实例上反射执行
	 * 
	 * @param proxy
	 *            代理类实例
	 * @param method
	 *            被调用的方法对象
	 * @param args
	 *            调用参数
	 * @return
	 * @throws Throwable
	 */
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 当代理对象调用真实对象的方法时，其会自动的跳转到代理对象关联的handler对象的invoke方法来进行调用
		Object returnValue = method.invoke(subject, args);
		return returnValue;
	}
}