package com.collection.map;
import java.util.*;
class Key {
  public String value;
  public Key(String value) {
    this.value = value;
  }
  
  @Override
  public int hashCode() {
    return this.value.hashCode();
  }
  
  @Override
  public boolean equals(Object obj) {
    return this.value.equals(((Key)obj).value);
  }
}
public class ModifyingKeyOfMap {
  public static void main(String[] args) throws InterruptedException {
    
    Key k1 = new Key("1");
    Key k2 = new Key("2");
    Key k3 = new Key("3");

    Map<Key, String> map = new HashMap<>();
    
    map.put(k1, "Imran Khan");
    map.put(k2, "Vinay Kumar");
    map.put(k3, "Rahul Kumar");
    Thread t = new Thread(new Runnable() {
      @Override
      public void run() {
        k1.value = "11";
        System.out.println(k1);
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
      }
    }, "Demo Thread");
    t.start();
    Thread.sleep(2000);
    System.out.println("Finding value " + map.get(k1));
		
		/*Map<String, String> map2 = new HashMap<String, String>();
		final String k1 = "1";
		String k2 = "2";
		String k3 = "3";
		map2.put(k1, "Imran Khan");
		map2.put(k2, "Vinay Kumar");
		map2.put(k3, "Rahul Kumar");
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				k1.concat("1");
				System.out.println(k1);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}, "Demo Thread");
		t2.start();
		System.out.println("Finding value in map " + map2.get("1"));*/
	}

}
