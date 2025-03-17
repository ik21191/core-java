package com.collection.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

public class SortMapOnValueExample {

  public static void main(String[] args) {

    Map<String, String> unsortMap = new HashMap<>();
    unsortMap.put("2", "B");
    unsortMap.put("1", "A");
    unsortMap.put("4", "D");
    unsortMap.put("3", "B");
    unsortMap.put("7", "C");
    unsortMap.put("5", "z");
    unsortMap.put("6", "b");
    unsortMap.put("8", "a");

    System.out.println("Unsort Map......");
    // printMap(unsortMap);

    System.out.println("Sorted Map......");
    Map<String, String> sortedMap = sortByComparator(unsortMap);
    printMap(sortedMap);

  }

  private static Map<String, String> sortByComparator(Map unsortMap) {

    Set<java.util.Map.Entry<String, String>> list = unsortMap.entrySet();

    Comparator<Map.Entry<String, String>> comparator = new Comparator<Map.Entry<String, String>>() {
      @Override
      public int compare(Entry<String, String> o1, Entry<String, String> o2) {
        return o1.getValue().compareTo(o2.getValue());
      }
    };

    List<Entry<String, String>> sortedList = list.stream().sorted(comparator).collect(Collectors.toList());

    // put sorted list into map again //LinkedHashMap make sure order in which keys were inserted
    Map<String, String> sortedMap = new LinkedHashMap<>();

    sortedList.forEach(entry -> sortedMap.put(entry.getKey(), entry.getValue()));

    return sortedMap;
  }

  public static void printMap(Map<String, String> map) {
    for (Map.Entry<String, String> entry : map.entrySet()) {
      System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
    }
  }
}
