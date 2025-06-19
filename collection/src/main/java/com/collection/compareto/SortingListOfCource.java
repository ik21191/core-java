package com.collection.compareto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortingListOfCource {
  public static List<Cource> mySort(List<Cource> list) {
    CourceParent p = new CourceParent();
    p.setSortBy("desc_name");
    Collections.sort(list, p);
    return list;
  }

  public static void main(String[] args) {
    List<Cource> myList = new ArrayList<>();
    List<Cource> toSortList = new ArrayList<>();
    myList.add(new Cource(3, "Core Java", 500));
    myList.add(new Cource(5, "Accounts", 400));
    myList.add(new Cource(1, "Linux", 800));
    myList.add(new Cource(4, "J2EE", 300));
    myList.add(new Cource(2, "English", 900));
    System.out.println("Before..........");
    System.out.println(myList + "\nAfter...........");
    for (Cource c : myList) {
      Cource cource = c;
      toSortList.add(cource);
    }
    System.out.println(mySort(toSortList));
  }
}

class CourceParent extends Cource implements Comparator<Cource> {
  public int compare(Cource o1, Cource o2) {
    if ("desc_id".equalsIgnoreCase(getSortBy()))
      return o2.id - o1.id;
    else if ("asc_name".equalsIgnoreCase(getSortBy()))
      return o1.name.compareTo(o2.name);
    else if ("desc_name".equalsIgnoreCase(getSortBy()))
      return o2.name.compareTo(o1.name);
    else
      return o1.id - o2.id;
  }
}


class Cource {
  int id;
  String name;
  double fees;
  String sortBy = "desc_id";

  public Cource() {
    super();
  }

  public Cource(int id, String name, double fees) {
    super();
    this.id = id;
    this.name = name;
    this.fees = fees;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getFees() {
    return fees;
  }

  public void setFees(double fees) {
    this.fees = fees;
  }

  public String getSortBy() {
    return sortBy;
  }

  public void setSortBy(String sortBy) {
    this.sortBy = sortBy;
  }

  @Override
  public String toString() {
    return "  " + id + "  " + name + "  " + fees + "  " + sortBy;
  }
}


