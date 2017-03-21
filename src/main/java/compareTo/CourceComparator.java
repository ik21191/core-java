package compareTo;

import java.util.Comparator;

public class CourceComparator implements Comparator<Student> {
     public int compare(Student o1, Student o2) {
         return o1.cource.compareTo(o2.cource);
     }
}
