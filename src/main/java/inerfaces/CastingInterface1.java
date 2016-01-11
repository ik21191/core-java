package inerfaces;
interface X//Showing ClassCastException at run time
{
    public void display();
}
interface Y extends X
{
    public void print();
}
class UseY implements Y
{
    public void print()
    {
        System.out.println("print() of Y implemented by UseY");
    } 
    public void display()
    {
        System.out.println("display() of X implemented by UseY");
    }
}
class UseX implements X
{
    public void display()
    {
        System.out.println("display() of X implemented in UseX");
    }
}
public class CastingInterface1 
{
    public static void main(String arr[])
    {
//        X x=new UseY();
        X x=new UseX();
        x.display();
        Y y=(Y)x;
        y.display();
    }
}
