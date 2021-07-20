package com.example.sort;

public class 斐波那契数列 {

	public static void main(String[] args) {
		System.out.println(getNum2(5));

	}

	// 0,1,1,2,3,5,8
	private static int getNum2(int n) {
		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}
		int pre = 0;
		int mid = 1;
		int next = 0;
		for (int i = 0; i < n - 2; i++) {
			next = pre + mid;
			pre = mid;
			mid = next;
		}
		return next;
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param n
	 * @return
	 */
	// 0,1,1,2,3,5,8
	private static int getNum(int n) {
		if (n == 1) {
			return 0;
		}
		if (n == 2) {
			return 1;
		}
		int pre = 0;
		int next = 1;
		int last = 1;
		for (int i = 2; i < n; i++) {
			last = pre + next;
			pre = next;
			next = last;
		}
		return last;
	}

}
