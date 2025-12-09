package com.collection.compareto;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CompanyComparatorTest {

  public static void main(String[] args) {

    Company c1 = new Company("Imran", "Delhi", 104);
    Company c2 = new Company("Gautam", "Mumbai", 102);
    Company c3 = new Company("Arpit", "Kolkata", 103);
    Company c4 = new Company("Rahul", "Bangalore", 101);
    List<Company> list = new ArrayList<>();

    list.add(c1);
    list.add(c2);
    list.add(c3);
    list.add(c4);
    System.out.println("Before sort:");
    System.out.println(list);

    // Collections.sort(list, new CompanyNameComparator());
    // using java8
    list = list.stream().sorted(new CompanyNameComparator()).collect(Collectors.toList());
    System.out.println("\nAfter Company Name sort: ");
    System.out.println(list);
    
    list = list.stream().sorted(new CompanyIdComparator()).collect(Collectors.toList());
    System.out.println("\nSort using ID: ");
    System.out.println(list);
  }

}

class CompanyNameComparator implements Comparator<Company> {

  @Override
  public int compare(Company o1, Company o2) {
    return o1.getName().compareTo(o2.getName());
  }
}

class CompanyIdComparator implements Comparator<Company> {

  @Override
  public int compare(Company o1, Company o2) {
      return o1.getId() - o2.getId();
  }
}

class Company {

  private String name, address;
  private int id;

  public Company(String name, String address, int id) {
    super();
    this.name = name;
    this.address = address;
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String toString() {
    return this.id + "  " + this.name + "  " + this.address;
  }
}
