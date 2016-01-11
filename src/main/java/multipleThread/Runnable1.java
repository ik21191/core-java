package multipleThread;
class RunnableImpl implements Runnable
{
    public void run() 
    {
        System.out.println("Tread started.");
        System.out.println("run() method in RunnableImpl");
    }
    
}
public class Runnable1 
{
    public static void main(String arr[])
    {
        //Thread t1=new Thread(new RunnableImpl(),"T1");
        System.out.println("Starting thread......");
        //t1.start();
    }
}
