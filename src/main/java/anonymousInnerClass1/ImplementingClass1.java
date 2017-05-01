package anonymousInnerClass1;
class A
{
    public void display()
    {
        System.out.println("display() of A");
    }
}
interface X
{
    public void print();
}
public class ImplementingClass1 
{
    A a = new A()//Creating sub-class using Anonymous concept
    {
        @Override
        public void display()
        {
            System.out.println("display() of Anonymous Inner class.");
        }
    };
    X x = new X()//Creating anonymous class which implements an Interface
    {
        @Override// before jdk 1.5 it would show error
        public void print()
        {
            System.out.println("print() of Anonymous class implementing interface.");
        }
    };
   public static void main(String arr[])
   {
       ImplementingClass1 obj1=new ImplementingClass1();
       obj1.a.display();
       obj1.x.print();
   }
}
