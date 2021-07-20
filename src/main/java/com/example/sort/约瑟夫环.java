package com.example.sort;

import java.util.ArrayList;
import java.util.List;

public class 约瑟夫环 {

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i < 11; i++) {
			list.add(i);
		}
		int last = getLast(list, 3);
		System.out.println(last);

	}

	private static int getLast2(List<Integer> list, int n) {
		if (list != null && list.size() > 0) {
			while (list.size() != 1) {
				for (int i = 0; i < n - 1; i++) {
					list.add(list.remove(0));
				}
				list.remove(0);
			}
			return list.get(0);
		}
		return -1;
	}

	/**
	 * 
	 * 
	 * 
	 * 
	 * 
	 * 
	 * @param list
	 * @param n
	 * @return
	 */
	private static int getLast(List<Integer> list, int n) {
		if (list != null && list.size() > 0) {
			while (list.size() > 1) {
				for (int i = 0; i < n - 1; i++) {
					list.add(list.remove(0));
				}
				list.remove(0);
			}
			return list.get(0);
		}
		return -1;
	}

}
