package com.jg.datastructures;

public class Queue<T> {
	private final int INITIAL_SIZE = 3;
	private Object[] arr;
	private int front = -1;
	private int rare = -1;
	private int N = INITIAL_SIZE;

	public Queue() {
		arr = new Object[INITIAL_SIZE];
	}

	public boolean isEmpty() {
		if (front == -1)
			return true;
		else
			return false;
	}

	public void enqueue(T item) {
		if ((this.rare + 1) % this.N == this.front) {
			N = N * 2;
			Object[] arrTemp = new Object[N];
			int index = 0;
			for (int i = front; i < arr.length; i++) {
				arrTemp[index] = arr[i];
				index++;
			}
			for (int i = 0; i < front; i++) {
				arrTemp[index] = arr[i];
				index++;
			}
			arr = arrTemp;
			front = 0;
			rare = index;
			
		} else if (this.isEmpty()) {
			this.front = 0;
			this.rare = 0;
		} else {
			this.rare = (this.rare + 1) % N;
		}
		this.arr[this.rare] = item;
	}

	@SuppressWarnings("unchecked")
	public T dequeue() {
		T item;
		if (isEmpty()) {
			return null;
		} else if (front == rare) {
			item = (T) arr[front];
			front = -1;
			rare = -1;
		} else {
			item = (T) arr[front];
			front = (front + 1) % N;
		}
		return item;
	}
}
