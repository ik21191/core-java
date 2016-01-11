package compareTo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class SortingListOfObject1
{
    public void sort(List<Employee> emp)
    {
        Collections.sort(emp);
    }
    public static void main(String ar[])
    {
        List<Employee> list=new ArrayList<Employee>();
        list.add(new Employee("ZZ","Khan",7000));
        list.add(new Employee("AA3","Kumar",1000));
        list.add(new Employee("DD","Kumar",2000));
        list.add(new Employee("AA","Verman",3000));
        list.add(new Employee("BB","Malhotra",1000));
        list.add(new Employee("aa1","Kumar",1000));
        list.add(new Employee("dD","Malhotra",1000));
        SortingListOfObject1 sorter=new SortingListOfObject1();
        sorter.sort(list);
        System.out.println("Printing list of Emloyees...........");
        Iterator<Employee> itr=list.iterator();
        while(itr.hasNext())
        {
            Employee e=itr.next();
            System.out.println(e.fname+"\t"+e.lname+"\t"+e.salary);
        }
    }
}
