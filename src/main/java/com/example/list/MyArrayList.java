package com.example.list;

import java.util.ArrayList;

public class MyArrayList<T> {

	private final static int DEFAULT_CAPACITY = 10;

	private int theSize = 0;

	private T[] theItems;

	public MyArrayList() {
		doClear();
		new ArrayList<>();
	}

	public int size() {
		return theSize;
	}

	private void ensureCapacity(int newCapacity) {
		if (newCapacity < theSize) {
			return;
		}
		T[] oldItems = theItems;
		theItems = (T[]) new Object[newCapacity];
		for (int i = 0; i < theSize; i++) {
			theItems[i] = oldItems[i];
		}
	}

	public boolean isEmpty() {
		return theSize == 0;
	}

	public boolean add(T element) {
		add(size(), element);
		return true;
	}

	public void add(int index, T element) {
		if (index < 0 || index > size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		if (theItems.length == size()) {
			ensureCapacity(size() * 2 + 1);
		}
		for (int i = size(); i > index; i--) {
			theItems[i] = theItems[i - 1];
		}
		theItems[index] = element;
		theSize++;
	}

	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public void clear() {
		doClear();
	}

	private void doClear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}

	public T get(int index) {
		if (index < 0 || index >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return theItems[index];
	}

	public T set(int index, T element) {
		if (index < 0 || index >= size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		T oldValue = theItems[index];
		theItems[index] = element;
		return oldValue;
	}

	public T remove(int index) {
		if (index < 0 || index > size()) {
			throw new ArrayIndexOutOfBoundsException();
		}
		T removedValue = theItems[index];
		for (int i = index; i < size() - 1; i++) {
			theItems[i] = theItems[i + 1];
		}
		theSize--;
		return removedValue;
	}

	public int indexOf(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
