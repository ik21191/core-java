package compareTo;

import java.util.Comparator;

public class NameComparator implements Comparator<Student> 
{
   public int compare(Student st1, Student st2)
   {
        return st1.name.compareTo(st2.name);
   }
    
}
