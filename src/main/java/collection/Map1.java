package collection;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class Map1
{
    public static void main(String arr[])
    {
        Map map = new HashMap();
        map.put("key1", "Imran Khan");
        map.put(null, "ABC");
        Set s= map.entrySet();
        for(Object o : s){
        	Map.Entry e = (Map.Entry)o;
        	System.out.println(e.getKey());
        }
     }
}
