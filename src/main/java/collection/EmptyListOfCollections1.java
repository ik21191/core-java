package collection;
import java.util.*;
public class EmptyListOfCollections1
{
    public static void main(String arr[])throws Exception
    {
        List<String> list=Collections.<String>emptyList();
        //List<String> list=new ArrayList<String>();
        System.out.println("Adding element to list..............");
        System.out.println(list.add("Imran Khan"));
        System.out.println("Added.");
    }
}
