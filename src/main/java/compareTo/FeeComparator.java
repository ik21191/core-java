package compareTo;
import java.util.*;
public class FeeComparator implements Comparator<Student>
{
   public int compare(Student o1,Student o2)
   {
        return o1.fee-o2.fee;
    }
}
