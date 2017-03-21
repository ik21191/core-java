package collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConcurrentTest {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");
		Iterator<String> itr = list.iterator();
		while(itr.hasNext()) {
			itr.next();
			itr.remove();//It will not throw ConcurrenModificationException
			//System.out.println(list.remove("A"));//It will throw ConcurrenModificationException
		}
		System.out.println(list);
	}

}
