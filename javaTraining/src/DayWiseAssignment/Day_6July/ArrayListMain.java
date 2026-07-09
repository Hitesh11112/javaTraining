/**
 * ArrayListOperations.java
 *
 * Complete demonstration of every public method available on java.util.ArrayList,
 * plus the Collections utility methods (min, max, sort, etc.) commonly used with it.
 */

package DayWiseAssignment.Day_6July;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class ArrayListMain {

	public static void main(String[] args) {
		
        // 1. CONSTRUCTORS
        ArrayList<String> list = new ArrayList<>();                    // default capacity
        ArrayList<String> listCap = new ArrayList<>(20);                // initial capacity
        ArrayList<String> listFromCollection = new ArrayList<>(Arrays.asList("X", "Y", "Z")); // from Collection
 
        System.out.println("listFromCollection: " + listFromCollection);
 
        
        // 2. ADDING ELEMENTS
        list.add("Apple");                        // add(E)
        list.add("Banana");
        list.add(1, "Orange");                     // add(int, E)
        list.addAll(Arrays.asList("Mango", "Kiwi"));            // addAll(Collection)
        list.addAll(0, Arrays.asList("Fig", "Date"));           // addAll(int, Collection)
 
        System.out.println("\nAfter all add operations: " + list);
 
        
        // 3. ACCESSING ELEMENTS
        System.out.println("\nget(0): " + list.get(0));
        System.out.println("First element (get(0)): " + list.get(0));
        System.out.println("Last element (get(size-1)): " + list.get(list.size() - 1));
 

        	// 4. UPDATING ELEMENTS
        list.set(0, "Pineapple");                   // set(int, E)
        System.out.println("\nAfter set(0, \"Pineapple\"): " + list);
 
        list.replaceAll(s -> s.toUpperCase());       // replaceAll(UnaryOperator) - Java 8+
        System.out.println("After replaceAll (uppercase): " + list);
 
        // 5. SEARCHING ELEMENTS
        System.out.println("\ncontains(\"MANGO\"): " + list.contains("MANGO"));
        System.out.println("containsAll([\"MANGO\",\"KIWI\"]): " +
                list.containsAll(Arrays.asList("MANGO", "KIWI")));
        System.out.println("indexOf(\"MANGO\"): " + list.indexOf("MANGO"));
        System.out.println("lastIndexOf(\"MANGO\"): " + list.lastIndexOf("MANGO"));

        
        // 6. SIZE / CAPACITY MANAGEMENT
        System.out.println("\nsize(): " + list.size());
        System.out.println("isEmpty(): " + list.isEmpty());
 
        list.ensureCapacity(50);                     // ensureCapacity(int)
        System.out.println("ensureCapacity(50) called (no visible output, internal array resized)");
 
        list.trimToSize();                           // trimToSize()
        System.out.println("trimToSize() called (trims internal array to current size)");

        
        // 7. REMOVING ELEMENTS
        list.remove("KIWI");                         // remove(Object)
        System.out.println("\nAfter remove(\"KIWI\"): " + list);
 
        list.remove(0);                              // remove(int) - by index
        System.out.println("After remove(0): " + list);
 
        list.removeIf(s -> s.startsWith("F"));        // removeIf(Predicate) - Java 8+
        System.out.println("After removeIf(startsWith \"F\"): " + list);
 
        ArrayList<String> toRemoveAll = new ArrayList<>(Arrays.asList("DATE"));
        list.removeAll(toRemoveAll);                  // removeAll(Collection)
        System.out.println("After removeAll([\"DATE\"]): " + list);
 
        ArrayList<String> retainDemo = new ArrayList<>(list);
        ArrayList<String> toRetain = new ArrayList<>(list.subList(0, Math.min(2, list.size())));
        retainDemo.retainAll(toRetain);                // retainAll(Collection)
        System.out.println("retainAll() demo result: " + retainDemo);
 
        
        // 8. ITERATION
        System.out.println("\n-- for-each loop --");
        for (String s : list) {
            System.out.println(" - " + s);
        }
 
        System.out.println("-- Iterator --");
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            System.out.println(" - " + it.next());
        }
 
        System.out.println("-- ListIterator (forward) --");
        ListIterator<String> lit = list.listIterator();
        while (lit.hasNext()) {
            System.out.println(" - [" + lit.nextIndex() + "] " + lit.next());
        }
 
        System.out.println("-- ListIterator (backward, from end) --");
        ListIterator<String> litEnd = list.listIterator(list.size());
        while (litEnd.hasPrevious()) {
            System.out.println(" - [" + litEnd.previousIndex() + "] " + litEnd.previous());
        }
 
        System.out.println("-- forEach(Consumer) - Java 8+ --");
        list.forEach(s -> System.out.println(" - " + s));

        
        // 9. SORTING - Java 8+
        ArrayList<String> sortDemo = new ArrayList<>(list);
        sortDemo.sort(null);                          // natural ordering
        System.out.println("\nsort(null) -> " + sortDemo);
 
        sortDemo.sort(Collections.reverseOrder());     // custom Comparator
        System.out.println("sort(reverseOrder) -> " + sortDemo);

        
        // 10. CONVERSION
        Object[] objArray = list.toArray();            // toArray()
        System.out.println("\ntoArray(): " + Arrays.toString(objArray));
 
        String[] strArray = list.toArray(new String[0]); // toArray(T[])
        System.out.println("toArray(T[]): " + Arrays.toString(strArray));
 

        // 11. SUBLIST / SPLITERATOR
        if (list.size() >= 2) {
            List<String> sub = list.subList(0, 2);      // subList(int, int)
            System.out.println("\nsubList(0,2): " + sub);
        }
        System.out.println("spliterator() estimate size: " + list.spliterator().estimateSize());

        
        // 12. CLONING / EQUALITY / HASHING
        @SuppressWarnings("unchecked")
        ArrayList<String> cloned = (ArrayList<String>) list.clone();  // clone()
        System.out.println("\nclone(): " + cloned);
        System.out.println("list.equals(cloned): " + list.equals(cloned));
        System.out.println("list.hashCode() == cloned.hashCode(): " +
                (list.hashCode() == cloned.hashCode()));
 
        
        // 13. CLEARING
        ArrayList<String> toClear = new ArrayList<>(list);
        toClear.clear();                                 // clear()
        System.out.println("\nAfter clear(): " + toClear + " | isEmpty: " + toClear.isEmpty());

        
        // FINAL STATE (String list demo)
        System.out.println("\nFinal working list: " + list);
        System.out.println("toString(): " + list.toString());
 

        // 14. Collections UTILITY METHODS (not part of ArrayList itself, but
        //     commonly used with it) - demonstrated on a numeric ArrayList<Integer>
        //     so min/max/abs actually make sense.
        System.out.println("\n\n========== Collections utility methods on ArrayList<Integer> ==========");
 
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(15, -4, 8, 42, -23, 8, 16, 4));
        System.out.println("\nOriginal numeric list: " + nums);

        
        // ---- min / max ----
        System.out.println("Collections.max(nums): " + Collections.max(nums));
        System.out.println("Collections.min(nums): " + Collections.min(nums));
        System.out.println("Collections.max(nums, by abs value): " +
                Collections.max(nums, (a, b) -> Math.abs(a) - Math.abs(b)));
        System.out.println("Collections.min(nums, by abs value): " +
                Collections.min(nums, (a, b) -> Math.abs(a) - Math.abs(b)));
 
        
        // ---- abs (Math class - applied element-wise) ----
        ArrayList<Integer> absValues = new ArrayList<>();
        for (int n : nums) {
            absValues.add(Math.abs(n));
        }
        System.out.println("Absolute values (Math.abs applied element-wise): " + absValues);
 
        
        // ---- sum / average (via simple loop) ----
        int sum = 0;
        for (int n : nums) sum += n;
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average of elements: " + (sum / (double) nums.size()));
 
        
        // ---- sort / reverse ----
        ArrayList<Integer> sortedNums = new ArrayList<>(nums);
        Collections.sort(sortedNums);
        System.out.println("\nCollections.sort() -> " + sortedNums);
 
        Collections.sort(sortedNums, Collections.reverseOrder());
        System.out.println("Collections.sort(reverseOrder()) -> " + sortedNums);
 
        Collections.reverse(sortedNums);
        System.out.println("Collections.reverse() -> " + sortedNums);
 
        
        // ---- frequency ----
        System.out.println("\nCollections.frequency(nums, 8): " + Collections.frequency(nums, 8));
 
        
        // ---- binarySearch (list must be sorted first) ----
        ArrayList<Integer> forSearch = new ArrayList<>(nums);
        Collections.sort(forSearch);
        System.out.println("Sorted for search: " + forSearch);
        System.out.println("Collections.binarySearch(forSearch, 16): " +
                Collections.binarySearch(forSearch, 16));
 
        
        // ---- swap ----
        ArrayList<Integer> swapDemo = new ArrayList<>(nums);
        Collections.swap(swapDemo, 0, swapDemo.size() - 1);
        System.out.println("\nCollections.swap(0, last) -> " + swapDemo);
 
        
        // ---- rotate ----
        ArrayList<Integer> rotateDemo = new ArrayList<>(nums);
        Collections.rotate(rotateDemo, 2);
        System.out.println("Collections.rotate(distance=2) -> " + rotateDemo);
 
        
        // ---- fill ----
        ArrayList<Integer> fillDemo = new ArrayList<>(nums);
        Collections.fill(fillDemo, 0);
        System.out.println("Collections.fill(0) -> " + fillDemo);
 
        
        // ---- copy ----
        ArrayList<Integer> copySrc = new ArrayList<>(Arrays.asList(100, 200, 300));
        ArrayList<Integer> copyDest = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Collections.copy(copyDest, copySrc);
        System.out.println("Collections.copy(dest, src) -> " + copyDest);
 
        
        // ---- replaceAll (Collections version) ----
        ArrayList<Integer> replaceDemo = new ArrayList<>(nums);
        Collections.replaceAll(replaceDemo, 8, 999);
        System.out.println("\nCollections.replaceAll(8 -> 999) -> " + replaceDemo);
 
        
        // ---- disjoint ----
        ArrayList<Integer> other = new ArrayList<>(Arrays.asList(1, 2, 3));
        System.out.println("Collections.disjoint(nums, [1,2,3]): " + Collections.disjoint(nums, other));
 
        
        // ---- nCopies ----
        System.out.println("Collections.nCopies(3, \"X\"): " + Collections.nCopies(3, "X"));
 
        
        // ---- synchronizedList ----
        List<Integer> syncList = Collections.synchronizedList(nums);
        System.out.println("Collections.synchronizedList() wrapper created: " + syncList);
 
        
        // ---- emptyList ----
        List<Integer> empty = Collections.emptyList();
        System.out.println("Collections.emptyList(): " + empty);
 	
	}

}
