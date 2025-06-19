package com.collection.map;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortMapUsingCustomObjectDemo {

  public static void main(String[] args) {
    HashMap<Key1, Value> map = new HashMap<>();
    
    map.put(new Key1(104, "Imran"), new Value(203, "Rakesh"));
    map.put(new Key1(101, "Raj"), new Value(205, "Roy"));
    map.put(new Key1(105, "Test"), new Value(201, "Reen"));
    map.put(new Key1(102, "Kishan"), new Value(202, "Test Value"));
    map.put(new Key1(103, "Tina"), new Value(204, "Hello"));
    
    Comparator<Map.Entry<Key1, Value>> com = Map.Entry.comparingByKey((o1, o2) -> o1.getId() - o2.getId());
    map.entrySet().stream().sorted(com).collect(Collectors.toList()).
    forEach(entry->System.out.println("key id: " + entry.getKey().getId() + "  value id: " + entry.getValue().getId()));
  }
}

class Key1 {
  private int id;
  private String name;
  
  public Key1(int id, String name) {
    super();
    this.id = id;
    this.name = name;
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
  @Override
  public int hashCode() {
    return this.id + this.name.hashCode();
  }
  @Override
  public boolean equals(Object obj) {
    Key1 key = (Key1)obj;
    return this.id == key.getId() && this.name.equals(key.name);
  }
  @Override
  public String toString() {
    return "Key1 [id=" + id + ", name=" + name + "]";
  }
}

class Value {
  private int id;
  private String name;
  
  public Value(int id, String name) {
    super();
    this.id = id;
    this.name = name;
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
  @Override
  public int hashCode() {
    return this.id + this.name.hashCode();
  }
  @Override
  public boolean equals(Object obj) {
    Value value = (Value)obj;
    return this.id == value.getId() && this.name.equals(value.name);
  }
  @Override
  public String toString() {
    return "Value [id=" + id + ", name=" + name + "]";
  }
}
