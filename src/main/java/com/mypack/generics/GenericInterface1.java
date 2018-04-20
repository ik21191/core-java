package com.mypack.generics;

class GenericTest<T1, T2> {
	private T1 t1;
	private T2 t2;
	
	public GenericTest(T1 t1, T2 t2) {
		this.t1 = t1;
		this.t2 = t2;
	}
	
	public void display() {
		System.out.println("T1 is: " + t1);
		System.out.println("T2 is: " + t2);
	}
}

interface MyInterface<T> {
    public void display(T t);
    public T getObj();
}
public class GenericInterface1 implements MyInterface<GenericInterface1>
{
	@Override
    public void display(GenericInterface1 ge){
        System.out.println("display(T ) in GenericInterface1");
    }
    @Override
    public GenericInterface1 getObj(){
    	return new GenericInterface1();
    }
    public static void main(String arr[]){
        MyInterface<GenericInterface1> g = new GenericInterface1();
        g.display(new GenericInterface1());
        
        GenericTest<String, Integer> genericTest = new GenericTest<>("Imran", 101);
        genericTest.display();
    }
}

