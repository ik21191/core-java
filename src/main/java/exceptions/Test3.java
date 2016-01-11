package exceptions;
public class Test3 
{
    public static void display()
    {
        String s=null;s.length();
        
    }
    public static void main(String arr[])
    {
        try{display();}catch(Exception e){
            System.out.println("hello in exception");
        };
        System.out.println("hello.");
    }
}
