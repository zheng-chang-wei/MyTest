package com.example.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author zcw
 * @date 2021/07/14
 * <p>
 * Description:
 **/
public class UserProxy<T> {
    T targer;

    public UserProxy(T targer) {
        this.targer = targer;
    }

    public T getInstence() {
        return (T) Proxy.newProxyInstance(targer.getClass().getClassLoader(), targer.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return method.invoke(proxy,args);
            }
        });
    }
}
