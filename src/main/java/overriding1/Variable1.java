package overriding1;
class V
{
    int a=100;
}
public class Variable1 extends V
{
    public int val()
    {
        try
        {
            System.out.println("try block");
            return 150;
        }
        catch(Exception e)
        {
            System.out.println("catch block");
        }
        finally
        {
            System.out.println("finally block");
        }
        System.out.println("try-catch end");
        return 200;
    }
    int a=200;
    public static void main(String arr[])
    {
       V v=new Variable1();
       Variable1 v1=new Variable1();
       System.out.println(v.a);
        System.out.println("======="+v1.val());
    }
}
