import java.util.*;

public class Hashing {
  // // implementing hashmap
  // static class HashMap<K, V> {  // generic 
  //   private class Node {
  //     K key;
  //     V value;

  //     public Node(K key, V value) {
  //       this.key = key;
  //       this.value = value;
  //     }
      
  //   }
  //   private int size; //n
  //   private int arr[];
  //   private LinkedList<Node> buckets[]; // N = buckets.length

  //   @SupressWarnings("unchecked")
  //   public HashMap() {
  //     this.size = 0;
  //     this.buckets = new LinkedList[4];
  //     for(int i=0; i<4; i++) {
  //       this.buckets[i] = new LinkedList<>();
  //     }
  //   }

  //   public void put(K key, V value) {

  //   }

  //   public boolean containsKey(K key) {
  //     return false;
  //   }

  //   public V remove(K key) {
  //     return null;
  //   }

  //   public V remove(K key) {
  //     return null;
  //   }

  //   public V get(K key) {
  //     return null;
  //   }

  //   public ArrayList<K> keySet() {
  //     return null;
  //   }

// }


  public static void main(String[] args) {
    
    // Hashmap (Unordered map)

    //create
    HashMap<String, Integer> hm = new HashMap<>();
    //hashmap operations
    //insert
    hm.put("India", 100);
    hm.put("US", 50);
    hm.put("UK", 80);

    // System.out.println(hm);

    // //get
    // System.out.println(hm.get("US"));

    // //containsKey
    // System.out.println(hm.containsKey("China")); // ans - false

    // //remove
    // System.out.println(hm.remove("US"));
    // System.out.println(hm);


    // //size
    // System.out.println(hm.size());

    // //isEmpty
    // hm.clear(); // use to empty the hashmap
    // System.out.println(hm.isEmpty());


    // // Iteration on hashmap
    // Set<String> keys = hm.keySet();
    // System.out.println(keys);

    // for (String k : keys) {
    //   System.out.println("key = " + k + " , value = " + hm.get(k));
    // }




    // implementation hashmap
    // write code using incomplete class above












    // // LinkedHashMap
    // LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();
    // lhm.put("India", 100);
    // lhm.put("US", 80);
    // lhm.put("UK", 90);
    // lhm.put("NZ", 50);

    // System.out.println(lhm);









    // //TreeMap - sorted according to key
    // TreeMap<String, Integer> tm = new TreeMap<>();
    // tm.put("India", 100);
    // tm.put("US", 80);
    // tm.put("UK", 90);
    // tm.put("NZ", 50);

    // System.out.println(tm);


































    // SET


    // HashSet
    // HashSet<Integer> hs = new HashSet<>();
    // // hashset operators
    // hs.add(1);
    // hs.add(2);
    // hs.add(4);
    // hs.add(2);
    // hs.add(1);

    // System.out.println(hs);


    // iteration on hashset
    // HashSet<String> cities = new HashSet<>();
    // cities.add("Delhi");
    // cities.add("Mumbai");
    // cities.add("Noida");
    // cities.add("Gurugram");
    // cities.add("Bengaluru");

    // // 1 - using iterators
    // Iterator it = cities.iterator();
    // while(it.hasNext()) {
    //   System.out.println(it.next());
    // }


    // // 2 - using enhanced loops
    // for (String city : cities) {
    //   System.out.println(city);
    // }







    // // LinkedHashSet
    // LinkedHashSet<String> lhs = new LinkedHashSet<>();
    // lhs.add("Delhi");
    // lhs.add("Mumbai");
    // lhs.add("Noida");
    // lhs.add("Gurugram");
    // lhs.add("Bengaluru");

    // System.out.println(lhs);



    // // TreeSet
    // TreeSet<String> ts = new TreeSet<>();
    // ts.add("Delhi");
    // ts.add("Mumbai");
    // ts.add("Noida");
    // ts.add("Gurugram");
    // ts.add("Bengaluru");

    // System.out.println(ts);





    // questions

  }
}