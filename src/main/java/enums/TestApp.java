package enums;

import java.util.ArrayList;
import java.util.List;

public class TestApp {

	public static void main(String[] args) {
		
		//System.out.println(Test.ERROR1);
		List<Test> list = new ArrayList<Test>();
		list.add(Test.ERROR1);
		list.add(Test.ERROR2);
		list.add(Test.ERROR3);
		System.out.println(list);
	}
}
