package mypack.net;
final class X
{
	public int a=100;
}
public class BoxingUnboxing1 
{
	X x=new X();
	public void display(Integer i)
	{
		System.out.println(i.toString());
		System.out.println("Valud of x.a is "+x.a);
	}
	public static void main(String[] args) 
	{
		BoxingUnboxing1 o=new BoxingUnboxing1();
		o.display(100);
	}
}
