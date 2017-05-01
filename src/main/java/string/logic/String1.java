package string.logic;
public class String1
{
    public static void main(String arr[])
    {
        String name="imran";
        System.out.println(name);
        String name1="Imran Khan";
        String name2="Imran Khan";
        String name3=new String("Imran Khan");
        System.out.println("name1: "+name1+"   name2: "+name2);
        System.out.println(name1.equals(name2));
        System.out.println(name1==name2);
        System.out.println(name1==name3);
        
        String test="/index.html/aa/dkljkldjl/index.html";
        if(test.charAt(test.length()-11)=='/')
        	System.out.println("Valid URL");
        else
        	System.out.println("InValid URL");
        System.out.println("\n"+test.charAt(test.length()-11));
    }
}
