package serialization;
import java.io.Serializable;
public class Address implements Serializable
{
    String name;
    public Address(String name)
    {
        this.name=name;
    }
}
