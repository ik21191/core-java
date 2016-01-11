package collection1;
import java.util.*;

public class List1 
{
	public static void main(String[] args) 
	{
		List<String> list=new ArrayList<String>();
		list.add(null);
		System.out.println(list.contains(null));
		List sList=new ArrayList();
		sList.add(new Student("Imran Khan"));
		sList.add(new Student("Vinay Kumar"));
		for(Object o:sList)
		{
			Student s=(Student)o;
			System.out.println(s);
		}
	}

}
