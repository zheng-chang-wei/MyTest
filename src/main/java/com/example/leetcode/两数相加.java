package com.example.leetcode;

import com.example.leetcode.common.ListNode;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * <p>如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * <p>您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * <p>输入：(2 -> 4 -> 3) + (5 -> 6 -> 4) 输出：7 -> 0 -> 8 原因：342 + 465 = 807
 */
public class 两数相加 {

	public static void main(String[] args) {
		ListNode listNode1 = new ListNode(2);
		ListNode listNode2 = new ListNode(4);
		ListNode listNode3 = new ListNode(3);
		ListNode listNode4 = new ListNode(5);
		ListNode listNode5 = new ListNode(6);
		ListNode listNode6 = new ListNode(4);

		listNode1.next = listNode2;
		listNode2.next = listNode3;

		listNode4.next = listNode5;
		listNode5.next = listNode6;

		ListNode addTwoNumbers = addTwoNumbers2(listNode1, listNode4);
		System.out.println(addTwoNumbers.val);
		System.out.println(addTwoNumbers.next.val);
		System.out.println(addTwoNumbers.next.next.val);

	}
	public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode head = null, tail = null;
		int carry = 0;
		while (l1 != null || l2 != null) {
			int n1 = l1 != null ? l1.val : 0;
			int n2 = l2 != null ? l2.val : 0;
			int sum = n1 + n2 + carry;
			if (head == null) {
				head = tail = new ListNode(sum % 10);
			} else {
				tail.next = new ListNode(sum % 10);
				tail = tail.next;
			}
			carry = sum / 10;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		if (carry > 0) {
			tail.next = new ListNode(carry);
		}
		return head;
	}
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		String v1 = getValue(l1);
		String v2 = getValue(l2);
		String value = addTwoString(v1, v2);
		System.out.println(value);
		ListNode node = new ListNode(Integer.valueOf(String.valueOf(value.charAt(0))));
		ListNode tempListNode = node;
		for (int i = 1; i < value.length(); i++) {
			ListNode newNode = new ListNode(Integer.valueOf(String.valueOf(value.charAt(i))));
			tempListNode.next = newNode;
			tempListNode = tempListNode.next;
		}
		return node;
	}

	private static String getValue(ListNode l) {
		StringBuilder sb = new StringBuilder();
		sb.append(l.val);
		while (l.next != null) {
			sb.append(l.next.val);
			l = l.next;
		}
		return sb.toString();
	}

	private static String addTwoString(String a, String b) {
		int lengthA = a.length();
		int lengthB = b.length();
		int length = lengthA > lengthB ? lengthA : lengthB;
		// 进位值
		int temp = 0;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int elementA = 0;
			if (i < lengthA) {
				elementA = Integer.valueOf(String.valueOf(a.charAt(i)));
			}
			int elementB = 0;
			if (i < lengthB) {
				elementB = Integer.valueOf(String.valueOf(b.charAt(i)));
			}
			int value = elementA + elementB + temp;
			if (value >= 10) {
				temp = 1;
			} else {
				temp = 0;
			}
			builder.append(value % 10);
		}
		if (temp != 0) {
			builder.append(temp);
		}
		return builder.toString();
	}

}

