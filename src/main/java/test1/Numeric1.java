package test1;
public class Numeric1 extends Thread
{
    public  synchronized void display()throws Exception
    {
        for(int i=0;i<5;i++)
        {
            Thread.sleep(2000);
            System.out.println(i);
        }
    }

    public void run()
    {
        try{
            System.out.println("Name of Thread "+Thread.currentThread().getName());
        display();}catch(Exception e){}
    }
    
    public static void main(String arr[])throws Exception
    {
        long l=1234561231l;
        System.out.println("Long value is  "+l);
        System.out.println("Calling first time");
        Numeric1 o1=new Numeric1();
        Numeric1 o2=new Numeric1();
        o1.start();
        System.out.println("Calling second time");
        o2.start();
    }
}
