package stringBuilderBuffer;
public class StringBuffer1 extends Thread
{
    static StringBuffer sbf=new StringBuffer("Imran Khan");
    public StringBuffer1(String s)
    {
        super(s);
    }
    public void run()
    {
        Thread t=Thread.currentThread();
        System.out.println("Thread name is "+t.getName());
        sbf.append(" Hariom Media");
        System.out.println(sbf);
    }
    public static void main(String arr[])throws Exception
    {
        StringBuffer1 t1=new StringBuffer1("Thread 1");
        StringBuffer1 t2=new StringBuffer1("Thread 2");
        t1.start();
        t1.sleep(5000);
        sbf.append("abc");
        t2.start();
    }
}
