package com.example.leetcode;

public class 两个字符串相加 {

	public static void main(String[] args) {
		String a = "5";
		String b = "5";
		String addTwoString = addTwoString(a, b);
		System.out.println(addTwoString);
	}

	public static String addTwoString(String a, String b) {
		int lengthA = a.length();
		int lengthB = b.length();
		int length = lengthA > lengthB ? lengthA : lengthB;
		// 进位值
		int temp = 0;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int elementA = 0;
			if (i < lengthA) {
				elementA = Integer.valueOf(String.valueOf(a.charAt(lengthA - 1 - i)));
			}
			int elementB = 0;
			if (i < lengthB) {
				elementB = Integer.valueOf(String.valueOf(b.charAt(lengthB - 1 - i)));
			}
			int value = elementA + elementB + temp;
			if (value >= 10) {
				temp = 1;
			} else {
				temp = 0;
			}
			builder.insert(0, value % 10);
		}
		if (temp != 0) {
			builder.insert(0, temp);
		}
		return builder.toString();
	}
}
