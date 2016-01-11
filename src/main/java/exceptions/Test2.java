package exceptions;
public class Test2 
{
    public static void display()
    {
        //String s=null;s.length();
        System.out.println("display() of Test2");
        try
        {
            throw new Exception();
            //System.out.println("");
        }catch(Exception e){ System.out.println("exception in display");
        }
    }
    public static void main(String arr[])
    {
        System.out.println("hello world !");
        display();
        String s=null;
        s.length();
        try
        {
            System.out.println("Hello 1");
            display();
            System.out.println("hello 5");
        }
        catch(Exception e)
        {
            System.out.println("hello 2");
            System.out.println(e);
        }
        finally
        {
            System.out.println("hello 3");
        }
        System.out.println("hello 4");
    }
}
