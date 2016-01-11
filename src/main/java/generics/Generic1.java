package generics;
import java.util.Arrays;
public class Generic1<T>
{
    private T t;
    String name;
    int value;
    public void setT(T t)
    {
        this.t=t;
    }
    public T getT()
    {
        return this.t;
    }
    public Generic1(String name)
    {
        this.name=name;
    }
    public Generic1(Integer value)
    {
        this.value=value;
    }
    public Generic1()
    {
        System.out.println("Default constructor.");
    }
    public Generic1(int x)
    {
        System.out.println("Default constructor.");
    }
    public static void main(String a[])
    {
        Generic1 s=new Generic1();
        Generic1<Integer> i=new Generic1<Integer>();
        System.out.println("Printing values of Object s..........");
        System.out.println("String value is "+s.name);
        System.out.println("Integer value is "+s.value);
        System.out.println("Printing values of Object i..........");
        System.out.println("String value is "+i.name);
        System.out.println("Integer value is "+i.value);
        //i.setT("abc");
        i.setT(10);// No Problem autoboxing
        i.setT(new Integer(10));//No Problem
        System.out.println("Setting String value.............");
        s.setT("Imran Khan");
        System.out.println("Getting String value............."+s.getT());
        System.out.println("Setting Integer value.............");
        s.setT(new Integer(1000));
        System.out.println("Getting Integer value............."+s.getT());
        
        }
}
