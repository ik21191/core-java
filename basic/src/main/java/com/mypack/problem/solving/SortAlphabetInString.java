package com.mypack.problem.solving;

import java.util.Arrays;

public class SortAlphabetInString {
  /**
   * This program demonstrate how to sort characters in a alphanumeric string without changing numerical position.
   * **/
  
  private static String sortCharacters(char[] chars) {
        
    StringBuilder sb = new StringBuilder();
    
    for(int i = 0; i < chars.length; i++) {
      if (Character.isLetter(chars[i])) {
        sb.append(chars[i]);
      }
    }
    
    char[] forSort = sb.toString().toCharArray();
    Arrays.sort(forSort);
    
    int j = 0;
    for(int i = 0; i < chars.length; i++) {
      if (Character.isLetter(chars[i])) {
        chars[i] = forSort[j];
        j++;
      }
    }
    return new String(chars);
  }

  public static void main(String[] args) {
    String value = "bca1d2e";
    System.out.println("Origional value : " + value);
    System.out.println("After sort : " + sortCharacters(value.toCharArray()));
  }
}
