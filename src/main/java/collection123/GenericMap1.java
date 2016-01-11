package collection123;
import java.util.*;
public class GenericMap1 
{
	public static void main(String arr[])
	{
		Map<String,String> m=new HashMap<String,String>();
		//m.put(new Object(), "");
		m.put("1", "AA");
		m.put("2", "AB");
		m.put("3", "AC");
		Set s=m.entrySet();
		Iterator<Map.Entry<String, String>> itr=s.iterator();
		while(itr.hasNext())
		{
			Map.Entry me=itr.next();
			System.out.println(me.getKey()+"          "+me.getValue());
		}
			
	}
}
