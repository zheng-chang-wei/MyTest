package com.example.链表实现栈;

import com.example.数组实现栈.MyArrayStack;

/**
 * @author yinglongwu
 */
public class Main {

	public static void main(String[] args) {
		
		//测试class ArrayStack
		MyNodeStack<Integer> stack = new MyNodeStack<>();
		
		//包装类和其对应的基本数据类型可以自动转换
		//将0到4入栈
		for (int i = 0; i < 11; i++) {
			stack.push(i);
			System.out.println(stack.peek());
		}

		//出一次栈
		stack.pop();
		System.out.println(stack.peek());
		System.out.println(stack);
	}

}
