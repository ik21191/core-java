package collection1;
import java.util.*;

public class List1 
{
	public static void main(String[] args) 
	{
		List<String> fixedSizeList = Arrays.asList(new String[]{"Imran", "Arpit", "Gautam Kumar"});
		//fixedSizeList.add("Rahul");//throw UnsupportedOperationException
		List<String> normalList = new ArrayList<String>();
		normalList.add("ABC");
		List<String> list = Collections.emptyList();
		list = normalList;
		list.add("Imran");
		System.out.println(list.size());
	}

}
