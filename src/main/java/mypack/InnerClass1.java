package mypack;
public class InnerClass1
{
    class Inner
    {
        void display()
        {
            System.out.println("display() of Inner");
            class Abc
            {

            }
        }
     }
    void displayOut()
    {
        System.out.println("displayOut() of InnerClass1");
    }
    public static void main(String arr[])
    {
        InnerClass1.Inner inner=new InnerClass1().new Inner();
        inner.display();
    }
}
