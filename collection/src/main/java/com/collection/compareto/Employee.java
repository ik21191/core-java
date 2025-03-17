package com.collection.compareto;
public class Employee implements Comparable<Employee> {

    public Employee(String fname, String lname, int salary) {
        this.fname = fname;
        this.lname = lname;
        this.salary = salary;
    }

    public Employee() {
    }
    
    String fname,lname;
    int salary;
    
    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee o) {
        return this.fname.toLowerCase().compareTo(o.fname.toLowerCase());
        //return this.salary-o.salary;// Salary wise sorting
    }
}
