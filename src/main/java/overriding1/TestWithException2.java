package overriding1;


class A2
{
	public void display()
	{
	//new FileInputStream("e://t1.txt");// It is checked exception, so define in try/catch or throw at method header
	}
	
    public void print()throws NullPointerException
    {
        System.out.println("print() of A1");
    }
}
class B2 extends A2
{
    public void print()//throws IOException
    {
    	A2 a2=null;
    	a2.display();
        System.out.println("print() of B");
    }
}
public class TestWithException2 
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
