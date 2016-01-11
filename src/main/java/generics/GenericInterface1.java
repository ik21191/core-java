package generics;
interface MyInterface<T>
{
    public void display(T t);
    public T getObj();
}
public class GenericInterface1 implements MyInterface<GenericInterface1>
{
	@Override
    public void display(GenericInterface1 ge)
    {
        System.out.println("display(T ) in GenericInterface1");
    }
    @Override
    public GenericInterface1 getObj() 
    {
    	return new GenericInterface1();
    }
    public static void main(String arr[])
    {
        MyInterface<GenericInterface1> g=new GenericInterface1();
        g.display(new GenericInterface1());
    }
}

