package accessModifier;
import mypack.*;
public class UseProtectedMethod extends AmbiguousMethodCalling
{
    public void displayAA()
    {
        AmbiguousMethodCalling a=new AmbiguousMethodCalling();
       System.out.println("Value of AA.aa is "+aa);
    }
    public static void main(String arr[])
    {
        UseProtectedMethod use=new UseProtectedMethod();
        use.display();
    }
}

