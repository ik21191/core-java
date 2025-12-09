package problem.solving;

import java.util.Arrays;

public class SortAlphabetInString {
  /**
   * This program demonstrate how to sort characters in a alphanumeric string without changing numerical position.
   * **/
  
  private static String sortCharacters(char[] chars) {
        
    StringBuilder sb = new StringBuilder();
    //extract all characters from main char array and append them to StrinbBuilder
    for(int i = 0; i < chars.length; i++) {
      if (Character.isLetter(chars[i])) {
        sb.append(chars[i]);
      }
    }
    
    //Converting string builder to char array
    char[] extractedChars = sb.toString().toCharArray();
    //sorting extracted char array
    Arrays.sort(extractedChars);
    
    //Replacing sorted chars into main char array
    int j = 0;
    for(int i = 0; i < chars.length; i++) {
      if (Character.isLetter(chars[i])) {
        chars[i] = extractedChars[j];
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
