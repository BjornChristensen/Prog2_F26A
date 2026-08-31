package collections;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
  public static void main(String[] args) {
    HashMap<String, Integer> map=new HashMap<>();
    map.put("Alice", 167);
    map.put("Bob", 187);
    map.put("Charlie", 187);
    map.put("David", 178);
    System.out.println(map);
    System.out.println("Bob".hashCode());

    map.put("Charlie", 199);
    System.out.println(map);

    System.out.println(map.get("Charlie"));
    map.remove("Charlie");

    for (String key: map.keySet()){
      System.out.println(key+": "+map.get(key));
    }

    for (Map.Entry<String, Integer> e: map.entrySet()){
      System.out.println(e);
    }

  }
}
