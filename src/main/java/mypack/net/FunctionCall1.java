package mypack.net;
public class FunctionCall1 
{
	static final String S=FunctionCall1.class.getName();
	public static void get()
	{
		System.out.println("method start........");
		System.out.println(S);
		System.out.println();
		int a=10;
		if(a==10)
		return ;
		System.out.println("get() method of FunctionCall");
		System.out.println("method end........");
	}
	public static void main(String[] args) 
	{
		//get();
		int a=100;
		int b=200;
		System.out.println("Value of a is :  "+a);
	}

}
