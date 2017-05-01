package mypack.net;
public class StringPattern1 
{
	public static void main(String[] args) 
	{
		String str="abcabc";
		System.out.println(str.matches(".*abc.*"));
	}

}
