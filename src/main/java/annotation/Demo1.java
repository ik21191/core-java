package annotation;
import java.lang.reflect.Method;
public class Demo1
{
    @MyAnnotation(authorName="Imran Khan")
    public static void toDisplay()
    {
        System.out.println("toDisplay() of Demo1");
    }
    public static void toPrint()
    {
        System.out.println("toPrint() of Demo1");
    }
    public static void showAnnotationInfo()
    {
        Demo1 demo=new Demo1();
        try
        {
            Class c=demo.getClass();
            Method m1=c.getMethod("toDisplay");
            Method m2=c.getMethod("toPrint");
            System.out.println("Checking whether the annotation is present or not on toPrint() method......");
            System.out.println("-------------------------------------");
            if(m2.isAnnotationPresent(MyAnnotation.class))
                System.out.println("YES");
            else
                System.out.println("NO");
            System.out.println("-------------------------------------");
            MyAnnotation an=(MyAnnotation)m1.getAnnotation(MyAnnotation.class);
            System.out.println("Printing MyAnnotation informations.........");
            String value=an.authorName();
            if(value.equalsIgnoreCase("Imran Khan"))
                System.out.println("Author is Imran Khan");
            else
                System.out.println("Imran Khan is not author of this Annotation.");
        }catch(Exception e)
        {
            System.out.println(e);
        }
    }
    public static void main(String arr[])
    {
        toDisplay();
        showAnnotationInfo();
    }
    
}
