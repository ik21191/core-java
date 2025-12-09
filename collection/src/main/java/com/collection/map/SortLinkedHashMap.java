package com.collection.map;

import java.util.*;
import java.util.Map.Entry;

class SortByKeyAscending implements Comparator<Entry<Integer, Integer>> {

  @Override
  public int compare(Entry<Integer, Integer> entry1, Entry<Integer, Integer> entry2) {
    return (entry1.getKey()).compareTo(entry2.getKey());
  }
}


public class SortLinkedHashMap {

  public static void main(String... a) {
    Map<Integer, Integer> map = new LinkedHashMap<>();
    map.put(4, 1);
    map.put(2, 1);
    map.put(3, 1);
    map.put(5, 1);

    Set<Entry<Integer, Integer>> entrySet = map.entrySet();
    List<Entry<Integer, Integer>> listOfentrySet = new ArrayList<>(entrySet);

    System.out.print("Before sorting by key : ");
    for (Entry<Integer, Integer> entry : listOfentrySet) {
      System.out.print(entry.getKey() + "=" + entry.getValue() + "  ");
    }

    Collections.sort(listOfentrySet, new SortByKeyAscending());

    System.out.print("\nAfter sorting by key(ascending): ");
    for (Entry<Integer, Integer> entry : listOfentrySet)
      System.out.print(entry.getKey() + "=" + entry.getValue() + "  ");
  }
}
