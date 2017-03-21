package collection.map;
import java.util.*;
public class ModifyingKeyOfMap {
	public static void main(String[] args) throws InterruptedException {
		
		/*Map<StringBuilder, String> map = new HashMap<StringBuilder, String>();
		final StringBuilder key1 = new StringBuilder("1");
		StringBuilder key2 = new StringBuilder("2");
		StringBuilder key3 = new StringBuilder("3");
		map.put(key1, "Imran Khan");
		map.put(key2, "Vinay Kumar");
		map.put(key3, "Rahul Kumar");
		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				key1.append("1");
				System.out.println(key1);
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "Demo Thread");
		t.start();
		Thread.sleep(2000);
		System.out.println("Finding value " + map.get(new StringBuilder("1")));*/
		
		Map<String, String> map2 = new HashMap<String, String>();
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
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}, "Demo Thread");
		t2.start();
		System.out.println("Finding value in map " + map2.get("1"));
	}

}
