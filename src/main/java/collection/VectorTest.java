package collection;

import java.util.Vector;

public class VectorTest {

	public static void main(String[] args) {
		
		Vector<String> v = new Vector<String>();
		v.add("A");
		v.add("B");
		v.add("C");
		v.add("D");
		v.add(null);
		System.out.println(v);
		
	}

}
