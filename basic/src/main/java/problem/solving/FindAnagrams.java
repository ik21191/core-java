package problem.solving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAnagrams {

  public static void main(String[] args) {
    String[] ar = {"dog", "god", "cat", "tac"};
    Map<String, List<String>> map = new HashMap<>();
    for(String str : ar) {
      char[] chr = str.toCharArray();
      Arrays.sort(chr);
      if (map.get(new String(chr)) != null) {
        List<String> list = map.get(new String(chr));
        list.add(str);
        map.put(new String(chr), list);
      } else {
        List<String> list = new ArrayList<>();
        list.add(str);
        map.put(new String(chr), list);
      }
    }
    System.out.println(map);
  }

}
