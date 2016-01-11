package mypack;
public class Boolean1
{
    public void display( boolean a,boolean b)
    {
        if(a)
            System.out.println("A");
        else if (a && b)
            System.out.println("A and B");
    }
    public static void main(String arr[])
    {
        Boolean1 bl=new Boolean1();
        bl.display(true,true);
    }
}
