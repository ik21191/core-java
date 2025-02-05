package com.mypack;

public class Parent {
	void send() {
		System.out.println("send() of X");
	}
	
	private void print() {
		System.out.println("print() of X");
	}
	
	protected void pass() {
		System.out.println("pass() of X");
	}
	
    public void display() {
    	System.out.println("display() of X");
    }
}
