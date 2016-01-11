package mypack;
import java.util.*;
public class Set1
{
    public static void main(String arr[])throws Exception
    {
        Set set=new HashSet();
        Emp e1=new Emp(101);
        System.out.println(set.add(e1));
        Emp e2=e1;
        System.out.println(set.add(e2));
                
    }
}
class Emp
{
    int a;
            Emp(int a)
            {
                this.a=a;
            }
}
