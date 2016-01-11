package exception;
class X
{
	
}
class Y
{
	
}
public class MethodException1 
{
	public static void display(){
	try
	{
		int a=1/0;
	}
	catch(Exception e)
	{
		
	}
	finally
	{
		System.out.println(new Exception());
	}
	System.out.println("Hello");
	}
	public static void main(String arr[])
	{
		display();
	
	X x=new X();
	X y=new X();
	System.out.println(x==y);
	}
}

