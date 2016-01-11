package exception;
public class ExceptionReturn 
{
	static int a=0;
	public void display()
	{
		try
		{
			System.out.println("try block");
			return;
		}catch(Exception e)
		{
			System.out.println("catch block: "+e);
		}
		finally
		{
			System.out.println("finally block called.");
		}
		System.out.println("after try-catch block");
	}
	public static void main(String[] args) 
	{
		ExceptionReturn r=new ExceptionReturn();
		r.display();
		System.out.println("this is main method");
	}
}
