package com.collection.compareto;
class Student implements Comparable<Student> 
{
    String name,cource;
    int fee;

    public Student(int fee,String name,String cource) {
        this.name = name;
        this.cource = cource;
        this.fee = fee;
    }

    public Student() {
    }
    
    public int compareTo(Student st) 
    {
        
        //return -(st.name.compareTo(this.name));//Sorting according to name
        //return -(st.cource.compareTo(this.cource));//Sorting according to cource
        return -(st.fee-this.fee);//Sorting according to fee
    }
    public void display()
    {
        System.out.println(name+"\t"+cource+"\t"+fee);
    }
}