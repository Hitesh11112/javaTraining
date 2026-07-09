/**
 * LinkedHashMapOperations.java
 *
 * Complete demonstration of every public method available on java.util.LinkedHashMap,
 * plus the Collections utility methods and Map idioms commonly used with it.
 *
 * IMPORTANT NOTE ON LinkedHashMap:
 * - LinkedHashMap stores Key-Value pairs (Map.Entry<K, V>). It extends HashMap.
 * - LinkedHashMap MAINTAINS insertion order by default (the order keys are put into the map).
 * - It can also be configured via a special constructor to maintain access order (most-recently accessed to least-recently accessed), making it perfect for building LRU Caches.
 * - Keys must be UNIQUE. Adding a duplicate key overwrites the old value and returns it.
 * - Values can be DUPLICATED.
 * - It allows ONE null key and MULTIPLE null values.
 * - LinkedHashMap has no index-based lookups (like get(int)). Lookups are performed via the key.
 * - Collections utility methods like sort(), shuffle(), reverse(), binarySearch() do NOT work
 *   directly on a Map. You must extract the keys, values, or entries into a List first.
 */

package DayWiseAssignment.Day_6July;

import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collection;

public class LinkedHashMapMain {
	
	public static void main(String[] args) {
		
		
		// 1. CONSTRUCTORS
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();                             // default capacity 16, load factor 0.75, insertion-order
        LinkedHashMap<String, Integer> mapCap = new LinkedHashMap<>(32);                         // initial capacity
        LinkedHashMap<String, Integer> mapCapLoad = new LinkedHashMap<>(32, 0.5f);               // capacity + load factor
        
        // Special Constructor for Access Order: capacity, load factor, accessOrder (true = access-order, false = insertion-order)
        LinkedHashMap<String, Integer> accessOrderMap = new LinkedHashMap<>(16, 0.75f, true);
        
        Map<String, Integer> initialData = Map.of("X", 10, "Y", 20, "Z", 30);
        LinkedHashMap<String, Integer> mapFromMap = new LinkedHashMap<>(initialData);            // from existing Map

        System.out.println("mapFromMap: " + mapFromMap);

        
        // 2. ADDING / UPDATING ELEMENTS
        // put(K, V) - returns previous value, or null if key was brand new
        map.put("Apple", 50);
        map.put("Banana", 30);
        
        // Updating an existing key (returns the old value 50)
        Integer oldAppleVal = map.put("Apple", 55); 
        System.out.println("\nOverwrote \"Apple\" -> old value was: " + oldAppleVal);

        // putIfAbsent(K, V) - Only adds if key doesn't exist or is mapped to null
        map.putIfAbsent("Apple", 99);  // ignored, Apple already exists
        map.putIfAbsent("Cherry", 75); // added successfully

        // putAll(Map) - copies all mappings from another map
        map.putAll(Map.of("Mango", 40, "Kiwi", 60, "Orange", 25));

        System.out.println("After all put operations: " + map);
        System.out.println("(Note: order shown IS exactly insertion order - LinkedHashMap guarantees it)");

        
        // 3. SEARCHING / ACCESSING ELEMENTS
        // get(Object key) - returns value or null if key doesn't exist
        System.out.println("\nget(\"Mango\"): " + map.get("Mango"));
        
        // getOrDefault(Object key, V defaultValue)
        System.out.println("getOrDefault(\"Grapes\", 0): " + map.getOrDefault("Grapes", 0));

        // Checking existence of keys or values
        System.out.println("containsKey(\"Banana\"): " + map.containsKey("Banana"));
        System.out.println("containsValue(60): " + map.containsValue(60));

        
        // 4. SIZE / EMPTY CHECK
        System.out.println("\nsize(): " + map.size());
        System.out.println("isEmpty(): " + map.isEmpty());

        
        // 5. REMOVING ELEMENTS
        // remove(Object key) - removes mapping, returns associated value
        Integer removedValue = map.remove("Kiwi");
        System.out.println("\nAfter remove(\"Kiwi\") [Value was " + removedValue + "]: " + map);

        // remove(Object key, Object value) - Conditional removal, returns boolean
        boolean removedConditional = map.remove("Banana", 99); // fails, value is 30
        System.out.println("Conditional remove (\"Banana\", 99) success: " + removedConditional);

        
        // 5.5 ADVANCED COMPUTE / MERGE IDIOMS 
        // computeIfAbsent - calculates value if key missing
        map.computeIfAbsent("Fig", key -> key.length() * 10); 
        System.out.println("\nAfter computeIfAbsent(\"Fig\"): " + map);

        // computeIfPresent - calculates new value if key exists
        map.computeIfPresent("Apple", (key, val) -> val + 5); 
        System.out.println("After computeIfPresent(\"Apple\"): " + map);

        // compute - recomputes value regardless of current existence
        map.compute("Cherry", (key, val) -> (val == null) ? 10 : val + 5);

        // merge - combines old value with a new value using a mapping function
        map.merge("Mango", 15, (oldVal, newVal) -> oldVal + newVal);
        System.out.println("After merge() adding 15 to \"Mango\": " + map);

        
        // 5.8 LinkedHashMap ACCESS ORDER DEMO
        System.out.println("\n--- Access Order Demo ---");
        accessOrderMap.put("One", 1);
        accessOrderMap.put("Two", 2);
        accessOrderMap.put("Three", 3);
        System.out.println("Before access: " + accessOrderMap);
        accessOrderMap.get("One"); // Accessing "One" moves it to the end of the map execution order
        System.out.println("After accessing 'One': " + accessOrderMap);

        
        // 6. ITERATION (Views of a Map)
        System.out.println("\n-- Iterating via entrySet() [Maintains Order] --");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(" - " + entry.getKey() + " => " + entry.getValue());
        }

        System.out.println("-- Iterating via keySet() [Maintains Order] --");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(" - Key: " + key);
        }

        System.out.println("-- Iterating via values() [Maintains Order] --");
        Collection<Integer> values = map.values();
        for (Integer val : values) {
            System.out.println(" - Value: " + val);
        }

        System.out.println("-- Iterating using EntrySet Iterator (safe removal) --");
        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<String, Integer> entry = it.next();
            if (entry.getKey().equals("Orange")) {
                it.remove(); // removes Orange securely from map
            }
        }

        System.out.println("-- forEach(BiConsumer) --");
        map.forEach((key, val) -> System.out.println(" - " + key + " -> " + val));

        
        // 7. CONVERSION / VIEWS
        // Converting Keys to an Array/List
        String[] keyArray = map.keySet().toArray(new String[0]);
        List<Integer> valueList = new ArrayList<>(map.values());
        
        System.out.println("\nExtracted Keys Array: " + Arrays.toString(keyArray));
        System.out.println("Extracted Values List: " + valueList);

        
        // 8. CLONING / EQUALITY / HASHING
        @SuppressWarnings("unchecked")
        LinkedHashMap<String, Integer> cloned = (LinkedHashMap<String, Integer>) map.clone(); // clone()
        System.out.println("\nclone(): " + cloned);
        System.out.println("map.equals(cloned): " + map.equals(cloned));
        System.out.println("map.hashCode() == cloned.hashCode(): " + 
                (map.hashCode() == cloned.hashCode()));

        
        // 9. CLEARING
        LinkedHashMap<String, Integer> toClear = new LinkedHashMap<>(map);
        toClear.clear();                                // clear()
        System.out.println("\nAfter clear(): " + toClear + " | isEmpty: " + toClear.isEmpty());

        // FINAL STATE
        System.out.println("\nFinal working map: " + map);
        System.out.println("toString(): " + map.toString());

        
        // 10. Collections UTILITY METHODS
        System.out.println("\n\n========== Collections utility methods on extracted Map views ==========");

        // Find min/max based on map values or keys using Collections utilities
        System.out.println("\nMax value in map: " + Collections.max(map.values()));
        System.out.println("Min key alphabetically: " + Collections.min(map.keySet()));

        // Sorting map elements requires extraction to a List
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(map.entrySet());
        
        // Sort entries by Value
        Collections.sort(entryList, (e1, e2) -> e1.getValue().compareTo(e2.getValue()));
        System.out.println("\n[Converted to Entry List first] Sorted by Value -> " + entryList);


        // ---- synchronizedMap ----
        Map<String, Integer> syncMap = Collections.synchronizedMap(map);
        System.out.println("Collections.synchronizedMap() wrapper created: " + syncMap);

        // ---- emptyMap ----
        Map<String, Integer> emptyMap = Collections.emptyMap();
        System.out.println("Collections.emptyMap(): " + emptyMap);
	}
}
