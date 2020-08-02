package com.mypack.generics;

import org.apache.log4j.Logger;

class GenericTest<T1, T2> {
	private static final Logger log = Logger.getLogger(GenericTest.class);
	
	private T1 t1;
	private T2 t2;
	
	public GenericTest(T1 t1, T2 t2) {
		this.t1 = t1;
		this.t2 = t2;
	}
	
	public void display() {
		if(t1 instanceof String) {
			log.info("T1 is String");
		}
		log.info("T1 is: " + t1);
		log.info("T2 is: " + t2);
	}
}

interface MyInterface<T> {
    public void display(T t);
    public T getObj();
}

class First {
	private static final Logger log = Logger.getLogger(First.class);
	public void displayFirst() {
		log.info("displayFirst() method called.");
	}
}

class Second {
	private static final Logger log = Logger.getLogger(Second.class);
	public void displaySecond() {
		log.info("displaySecond() method called.");
	}
}

class FirstImplementation implements MyInterface<First> {
	@Override
    public void display(First first){
		first.displayFirst();
    }
    @Override
    public First getObj(){
    	return new First();
    }
   
}

class SecondImplementation implements MyInterface<Second> {
	@Override
    public void display(Second second){
		second.displaySecond();
    }
    @Override
    public Second getObj(){
    	return new Second();
    }
}

public class GenericsDemo {
	private static final Logger log = Logger.getLogger(GenericsDemo.class);
	
	public static void main(String arr[]){
		log.info("Invoking FirstImplementation....");
		MyInterface<First> firstImplementation = new FirstImplementation();
		First firstObject = firstImplementation.getObj();
		firstImplementation.display(firstObject);
		
		log.info("Invoking SecondImplementation....");
		MyInterface<Second> secondImplementation = new SecondImplementation();
		Second secondObject = secondImplementation.getObj();
		secondImplementation.display(secondObject);
	
		GenericTest<String, Integer> genericTest = new GenericTest<>("Imran", 101);
		genericTest.display();
	}
}

