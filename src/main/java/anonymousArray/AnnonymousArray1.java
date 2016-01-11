package anonymousArray;
public class AnnonymousArray1 
{
    public static void display(String myNames[])
    {
        System.out.println("In display() method...........");
        System.out.println(myNames[0]);
        System.out.println(myNames[1]);
    }
    public static void main(String arr[])
    {
        String names[]=new String[]{"Imran Khan","Vinay Kumar","Chandan Trikha"};
        System.out.println(names[0]);
        System.out.println(names[1]);
        System.out.println(names[2]);
        display(names);
    }
}
