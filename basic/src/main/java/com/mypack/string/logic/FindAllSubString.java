package com.mypack.string.logic;

import java.util.Scanner;

public class FindAllSubString {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter source string");
    String sourceString = sc.nextLine();
    System.out.println("Enter sub string");
    String subString = sc.nextLine();

    int startIndex = 0;
    int count = 0;
    while ((startIndex = sourceString.indexOf(subString)) != -1) {
      System.out.println(++count);
      System.out.println(
          "Sub String: " + sourceString.substring(startIndex, startIndex + subString.length()));
      /** Example using substring(int startIndex, int endIndex) */
      // sourceString = sourceString.substring(startIndex + subString.length(),
      // sourceString.length());
      /** Example using substring(int index) */
      sourceString = sourceString.substring(startIndex + subString.length());

    }
    System.out.println("Total Count: " + count);

    sc.close();

  }

}
