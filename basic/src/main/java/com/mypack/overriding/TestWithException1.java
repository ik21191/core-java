package com.mypack.overriding;

import java.io.FileNotFoundException;

class A1 {
    protected void print()throws FileNotFoundException {//It is checked exception
        System.out.println("print() of A1");
    }
    protected void display()throws NullPointerException {//It is UnChecked exception
        System.out.println("display() of A1");
    }
    protected void write() {
    	System.out.println("write() in A1");
    } 
}
class B extends A1 {
	@Override
    public void print() {
        System.out.println("print() of B");
    }
    @Override
    public void display() {
        System.out.println("display() of B1");
    }
    /* If method in parent class not throwing checked exception then in sub-class you can't throw checked exception
    @Override
    protected void write() throws Exception {
    	System.out.println("write() in A1");
    }
    */
}
public class TestWithException1 {
    public static void main(String arr[]) {
        B b = new B();
        A1 a = new B();
        b.print();
        try{a.print();}catch(Exception e){} //will compile
        //a.print(); //not compile
        a.display();//Compile and Run fine
    }
}
