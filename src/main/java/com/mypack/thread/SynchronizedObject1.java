package com.mypack.thread;

public class SynchronizedObject1 {
	private int count = 0;

	public synchronized void increment() {
		count++;
	}

	public synchronized void decrement() {
		count--;
	}

	public int display() {
		return count;
	}
}
