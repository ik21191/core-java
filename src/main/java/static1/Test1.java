package static1;
class A
{
	public static B b=new B();
	public A(){
		System.out.println("Constructor of A");
	}
}
class B extends A
{
	public B()
	{
		System.out.println("Constructor of B");
	}
	public void display()
	{
		System.out.println("display() of B");
	}
}
public class Test1 {
	public static void main(String[] args) {
		A.b.display();
		System.out.println("hello");
	}
}