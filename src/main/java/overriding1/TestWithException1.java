package overriding1;

import java.io.FileNotFoundException;

class A1
{
    public void print()throws FileNotFoundException {//It is checked exception
        System.out.println("print() of A1");
    }
    public void display()throws NullPointerException {//It is UnChecked exception
        System.out.println("display() of A1");
    }
}
class B extends A1
{
    public void print() {
        System.out.println("print() of B");
    }
    public void display() {
        System.out.println("display() of B1");
    }
}
public class TestWithException1 
{
    public static void main(String arr[])
    {
        B b = new B();
        A1 a = new B();
        b.print();
        try{a.print();}catch(Exception e){} //will compile
        //a.print(); //not compile
        a.display();//Compile and Run fine
    }
}
