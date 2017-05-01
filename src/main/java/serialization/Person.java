package serialization;

import java.io.Serializable;

public class Person implements Serializable
{
    Address add;
    String name;
    public Person(String name, Address add)
    {
        this.name=name;
        this.add=add;
    }
    public String toString()
    {
        return "Person Name: " + name + "\tPerson Address: " + add.name;
    }
    
}
