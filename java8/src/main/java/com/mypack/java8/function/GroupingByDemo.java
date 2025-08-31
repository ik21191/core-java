package com.mypack.java8.function;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByDemo {

  public static void main(String[] args) {
    List<City> cities = Arrays.asList(
        new City("Meerut", 12000), 
        new City("Ghaziabad", 800000),
        new City("Delhi", 4500000), 
        new City("Mumbai", 1200000), 
        new City("Hapur", 60000));

    Map<String, List<String>> citiesBySize = cities.stream().collect(Collectors.groupingBy(city -> {
      // Determine population category
      if (city.getPopulation() < 100000)
        return "Small";
      else if (city.getPopulation() <= 1000000)
        return "Medium";
      else
        return "Large";
    }, 
    
     /*Collectors.mapping(city -> {
      // Determine population category
      if (city.getName().equals("Delhi")) {
        return "New Delhi";
      } else {
        return city.getName();
      }
    }*/
        
    Collectors.mapping(City::getName, Collectors.toList())));
    System.out.println(citiesBySize);
    // {Small=[Meerut, Hapur], Medium=[Ghaziabad], Large=[Delhi, Mumbai]}
  }
}


class City {
  String name;
  int population;

  City(String name, int population) {
    this.name = name;
    this.population = population;
  }

  public String getName() {
    return name;
  }

  public int getPopulation() {
    return population;
  }
}
