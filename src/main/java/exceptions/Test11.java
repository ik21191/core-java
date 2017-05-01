package exceptions;
class X
{
	public static void print()
	{
		int a=1/0;
	}
}
class A
{
	public static void display()
	{try{
		X.print();
		System.out.println("message after print() call");}catch(Exception e)
		{System.out.println("There is an exception in method call stack");}finally
		{
			System.out.println("this is finally block");
		}
	}
}
public class Test11
{
	/*public static int display()throws Exception
	{
		try
		{ int a=1/0;
			
		}catch(Exception e)
		{
			return 1;
			
		}
		finally
		{
			return 2;
		}
		*/
	
	public static void main(String arr[])
	{
		//throw new Exception("My Test Exception");
		//System.out.println(display());
		A.display();
		System.out.println("Hello after exception");
	}
}
