package overloading;
class T
{
    void display()
    {
        System.out.println("display() of T");
    }
}
class U extends T
{
    
}
public class Test1 extends T
{
    public void run(T t)
    {
        System.out.println("run(T t) of Test1");
    }
    public void run(U u)
    {
        System.out.println("run(U u) of Test1");
    }
    void /*String You can't override a method based on the return type*/ display()
    {
        //return 5;
    }
    public static void main(String arr[])
    {
        Test1 test=new Test1();
        U u=new U();
        test.run((T)u);// run(T t) of Test1
        test.run(u);// run(U u) of Test1
        //if run(U u) is not present then run(T t) will be called in both the cases
    }
}
