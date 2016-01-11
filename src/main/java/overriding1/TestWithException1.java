package overriding1;
class A1
{
    public void print()throws Exception
    {
        System.out.println("print() of A1");
    }
}
class B extends A1
{
    public void print()
    {
        System.out.println("print() of B");
    }
}
public class TestWithException1 
{
    public static void main(String arr[])
    {
        B b=new B();
        A1 a=new B();
        b.print();
        try{a.print();}catch(Exception e){} //will compile
        //a.print(); //not compile
    }
}
