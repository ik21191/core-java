package serialization;

import java.io.*;

public class Serialize1
{
    public static void main(String arr[])throws Exception
    {
        Address a1=new Address("Shalimar Bagh");
        Person p1=new Person("Imran Khan",a1);
        Address a2=new Address("Azad Pur");
        Person p2=new Person("Vinay Kumar",a2);
        FileOutputStream out=new FileOutputStream("e://object.ser");
        ObjectOutputStream objectOut=new ObjectOutputStream(out);
        System.out.println("Serializing object state...........");
        objectOut.writeObject(p1);
        objectOut.writeObject(p2);
        System.out.println("Saved.");
        System.out.println("Deserializing object state.........");
        FileInputStream in=new FileInputStream("e://object.ser");
        ObjectInputStream inObject=new ObjectInputStream(in);
        Person p=(Person)inObject.readObject();
        System.out.println(p);
    }
}
