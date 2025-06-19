package com.mypack.generics;

public class GenericWithTwoTypes {

  record User<T, U>(T userId, U password) {
  }

  public static void main(String[] args) {
    User<Integer, String> user1 = new User<>(101, "test123");

    User<Integer, Integer> user2 = new User<>(201, 1001);

    User<String, String> user3 = new User<>("test101", "pass101");

    System.out.println("user1: " + user1);
    System.out.println("user2: " + user2);
    System.out.println("user3: " + user3);
  }
}
