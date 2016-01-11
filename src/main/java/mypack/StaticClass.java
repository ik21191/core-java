package mypack;
public  class StaticClass
{
    private static String name;
    public static void display()
    {
        setName("imran khan");
        System.out.println("Displaying name   "+getName());
        
    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        StaticClass.name = name;
    }
    public static void main(String arr[])
    {
        StaticClass.display();
    }
    
}
