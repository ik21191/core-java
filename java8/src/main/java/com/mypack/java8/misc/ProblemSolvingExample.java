package com.mypack.java8.misc;

import java.lang.invoke.CallSite;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import com.itextpdf.text.log.SysoCounter;
import com.itextpdf.text.pdf.PdfStructTreeController.returnType;
import com.mysql.cj.x.protobuf.MysqlxCrud.Collection;
import lombok.val;

public class ProblemSolvingExample {
  
  public record Person(int id, String city) {};

  public static void main(String[] args) {

    // find second highest from int array
    findSecondHighest();
    
    //find number of count in an array
    findNumberOfCount();

  }

   private static void findSecondHighest() {
     System.out.println("Finding second largest from int array :");
    int[] ints = {5, 2, 8, 3, 10, 6};
    printArray(ints);
    

    // If you have Integer array then you can call below method to get second highest number
    // Arrays.sort(ints, Comparator.reverseOrder());
    // ints.[1];

    secondHighestWay1(ints);
    secondHighestWay2(ints);
 }

  private static void printArray(int[] ints) {
    Arrays.stream(ints).forEach(element->System.out.print(element + "  "));
  }

  private static void secondHighestWay1(int[] ints) {
    //To convert primitive array to wrapper array
    // java 8
    // List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());

    // java16 or later
    
    // List<Integer> list = Arrays.stream(ints).boxed().toList();
    
    System.out.println("\nsecondHighestWay11() output : "
        + Arrays.stream(ints).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().get());
  }

  private static void secondHighestWay2(int[] ints) {
    // convert primitive array to Integer array

    // IntFunction<Integer[]> intFunction = ints-> return Integer[];
    Integer[] integers = Arrays.stream(ints).boxed().toArray(Integer[]::new);
    System.out.println("\nsecondHighestWay2() output : " + integers[2]);
  }
  
  private static void findNumberOfCount() {
    System.out.println("Calculatin number of count \n");
    int[] ints = {3, 4, 1, 2, 3, 6, 7, 4, 1};
    printArray(ints);
    findNumberOfCountWay1(ints);
    findNumberOfCountWay2(ints);
    findNumberOfCountWay3(ints);
    findNumberOfCountWay4(ints);
  }

  private static void findNumberOfCountWay1(int[] ints) {
    //using map
    System.out.println("Calculating number of count \n");
    Map<Integer, Integer> map = new HashMap<>();
    for (int element : ints) {
      map.put(element, map.getOrDefault(element, 0) + 1);
    }
    System.out.println("findNumberOfCountWay1(): " + map);
  }
  
  private static void findNumberOfCountWay2(int[] ints) {
    //Now suppose we have list
    List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
    
    System.out.println("Calculating number of count \n");
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (Integer element : list) {
      if (map.get(element) != null) {
        List<Integer> tempList = map.get(element);
        tempList.add(element);
        map.put(element, tempList);
      } else {
        List<Integer> tempList = new ArrayList<>();
        tempList.add(element);
        map.put(element, tempList);
      }
    }
    System.out.println("findNumberOfCountWay2() ");
    map.forEach((key, value) -> System.out.print(key + " = " + value.size() +  "  ,"));
    
    System.out.println("\nfindNumberOfCountWay2() : display all duplicate specific to a number");
    map.forEach((key, value) -> System.out.print(key + " = " + value +  "  |"));
  }
  
  private static void findNumberOfCountWay3(int[] ints) {
    //Now suppose we have list
    List<Integer> list = Arrays.stream(ints).boxed().collect(Collectors.toList());
    
    //list.stream().collect(Collectors.groupingBy(value-> value, Collectors.counting()));
    //or
    Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    
    
    System.out.println("Calculating number of count \n");
    
    System.out.println("findNumberOfCountWay3() : " + map);
    
  }
  
  private static void findNumberOfCountWay4(int[] ints) {
    //Now suppose we have list
    List<Person> list = new ArrayList<>();
    list.add(new Person(101, "Delhi"));
    list.add(new Person(102, "Mumbai"));
    list.add(new Person(101, "Bhopal"));
    list.add(new Person(101, "Aligarh"));
    list.add(new Person(101, "UP"));
    
    //list.stream().collect(Collectors.groupingBy(value-> value, Collectors.counting()));
    //or
    Map<Integer, Long> map = list.stream().collect(Collectors.groupingBy
        (Person::id, Collectors.mapping(Person::city, Collectors.counting())));
    
    
    System.out.println("Calculating number of count \n");
    
    System.out.println("findNumberOfCountWay4() : " + map);
    
  }
  
}
