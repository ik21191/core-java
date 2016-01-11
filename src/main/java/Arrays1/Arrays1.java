package Arrays1;

import java.util.Arrays;

public class Arrays1 
{
    public static void main(String arr[])
    {
        int aa[]=new int[]{1,2};
        System.out.println(aa.length);
        aa=Arrays.copyOf(aa,aa.length*2);
        System.out.println("New length is: "+aa.length);
        for(int i:aa)
        {
            System.out.println(i);
        }
    }
}
