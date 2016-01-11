package mypack;
public class This1
{
    String name;
    public void x(This1 a)
    {
        a.name="xyz";
    }
    public void y()
    {
        x(this);
    }
    void display()
    {
        System.out.println("name is "+name);
    }
    public static void main(String arr[])
    {
        This1 t=new This1();
        t.name="abc";
        t.y();
        t.display();
    }
}
