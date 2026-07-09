/**
 * TreeMapOperations.java
 *
 * Complete demonstration of every public method available on java.util.TreeMap,
 * plus the Collections utility methods and Map idioms commonly used with it.
 *
 * IMPORTANT NOTE ON TreeMap:
 * - TreeMap stores Key-Value pairs (Map.Entry<K, V>).
 * - TreeMap MAINTAINS its keys in sorted, natural order (or by a custom Comparator).
 * - Keys must be UNIQUE. Adding a duplicate key overwrites the old value and returns it.
 * - It does NOT allow null keys (throws NullPointerException), but allows multiple null values.
 * - TreeMap has no index-based lookups (like get(int)). Lookups are performed via the key.
 * - It provides advanced navigational methods to find closest matching keys (floor, ceiling, etc.).
 */

package DayWiseAssignment.Day_6July;

import java.util.TreeMap;
import java.util.Iterator;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.NavigableMap;

public class TreeHashMapMain {
	
	public static void main(String[] args) {
		
		// 1. CONSTRUCTORS
        TreeMap<String, Integer> map = new TreeMap<>();                             // natural ordering of keys
        TreeMap<String, Integer> mapWithComparator = new TreeMap<>(Collections.reverseOrder()); // custom comparator order
        
        Map<String, Integer> initialData = Map.of("Z", 10, "Y", 20, "X", 30);
        TreeMap<String, Integer> mapFromMap = new TreeMap<>(initialData);            // from existing Map

        System.out.println("mapFromMap (automatically sorted by key): " + mapFromMap);

        
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
        System.out.println("(Note: order shown IS sorted alphabetical order by Key - TreeMap guarantees it)");

        
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

        
        // 5.8 TreeMap / NavigableMap SPECIFIC NAVIGATION METHODS
        System.out.println("\nFirst Key: " + map.firstKey() + " | First Entry: " + map.firstEntry());
        System.out.println("Last Key: " + map.lastKey() + " | Last Entry: " + map.lastEntry());
        
        System.out.println("Lower key than 'Mango' (<): " + map.lowerKey("Mango"));
        System.out.println("Floor entry of 'Mango' (<=): " + map.floorEntry("Mango"));
        System.out.println("Ceiling key of 'Banana' (>=): " + map.ceilingKey("Banana"));
        System.out.println("Higher entry than 'Banana' (>): " + map.higherEntry("Banana"));

        // Creating sorted sub-views of the map
        System.out.println("SubMap (Apple to Mango): " + map.subMap("Apple", "Mango"));
        System.out.println("HeadMap (up to Mango): " + map.headMap("Mango"));
        System.out.println("TailMap (from Mango onwards): " + map.tailMap("Mango"));

        // Descending mapping view
        NavigableMap<String, Integer> descendingMap = map.descendingMap();
        System.out.println("Descending Map view: " + descendingMap);

        // Polling elements (extracts and removes from the map boundaries)
        TreeMap<String, Integer> pollDemo = new TreeMap<>(map);
        System.out.println("Polled First Entry: " + pollDemo.pollFirstEntry() + " | Remaining: " + pollDemo);
        System.out.println("Polled Last Entry: " + pollDemo.pollLastEntry() + " | Remaining: " + pollDemo);


        // 6. ITERATION (Views of a Map)
        System.out.println("\n-- Iterating via entrySet() [Maintains Sorted Order] --");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(" - " + entry.getKey() + " => " + entry.getValue());
        }

        System.out.println("-- Iterating via keySet() [Maintains Sorted Order] --");
        Set<String> keys = map.keySet();
        for (String key : keys) {
            System.out.println(" - Key: " + key);
        }

        System.out.println("-- Iterating via values() [Ordered by corresponding sorted keys] --");
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
        TreeMap<String, Integer> cloned = (TreeMap<String, Integer>) map.clone(); // clone()
        System.out.println("\nclone(): " + cloned);
        System.out.println("map.equals(cloned): " + map.equals(cloned));
        System.out.println("map.hashCode() == cloned.hashCode(): " + 
                (map.hashCode() == cloned.hashCode()));

        
        // 9. CLEARING
        TreeMap<String, Integer> toClear = new TreeMap<>(map);
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
        
        // Sort entries by Value (instead of default Key sorting)
        Collections.sort(entryList, (e1, e2) -> e1.getValue().compareTo(e2.getValue()));
        System.out.println("\n[Converted to Entry List first] Sorted by Value -> " + entryList);

        // ---- synchronizedMap ----
        Map<String, Integer> syncMap = Collections.synchronizedMap(map);
        System.out.println("Collections.synchronizedMap() wrapper created: " + syncMap);

        // ---- emptyMap ----
        Map<String, Integer> emptyMap = Collections.emptyMap();
        System.out.println("Collections.emptyMap(): " + emptyMap);

        // ---- singletonMap ----
        Map<String, Integer> singletonMap = Collections.singletonMap("OnlyKey", 999);
        System.out.println("Collections.singletonMap(\"OnlyKey\", 999): " + singletonMap);		
	}
}
