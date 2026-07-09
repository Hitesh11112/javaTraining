/**
 * VectorOperations.java
 *
 * Complete demonstration of every public method available on java.util.Vector
 * (as of current JDK releases), including legacy methods, Collection-interface
 * methods, and the newer Java 8+ default methods (forEach, removeIf, replaceAll,
 * sort, spliterator).
 */

package DayWiseAssignment.Day_6July;

import java.util.Vector;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;

public class VectorMain {

	public static void main(String[] args) {
		
		// 1. CONSTRUCTORS
        Vector<String> vector = new Vector<>();                     // default capacity 10
        Vector<String> vectorCap = new Vector<>(20);                 // initial capacity
        Vector<String> vectorCapInc = new Vector<>(5, 3);            // capacity + increment //inc of 3 when the arr IS FULL
        Vector<String> vectorFromList = new Vector<>(Arrays.asList("X", "Y", "Z")); // from Collection
 
        System.out.println("vectorCap capacity: " + vectorCap.capacity());
        System.out.println("vectorFromList: " + vectorFromList);
        
        
        // 2. ADDING ELEMENTS
        vector.add("Apple");                     // add(E)
        vector.add("Banana");
        vector.addElement("Cherry");             // addElement(E) - legacy
        vector.add(1, "Orange");                 // add(int, E)
        vector.insertElementAt("Grapes", 2);      // insertElementAt(E, int) - legacy
        vector.addAll(Arrays.asList("Mango", "Kiwi"));           // addAll(Collection)
        vector.addAll(0, Arrays.asList("Fig", "Date"));          // addAll(int, Collection)
 
        System.out.println("\nAfter all add operations: " + vector);
		
        
        // 3. ACCESSING ELEMENTS
        System.out.println("\nget(0): " + vector.get(0));
        System.out.println("elementAt(1): " + vector.elementAt(1));
        System.out.println("firstElement(): " + vector.firstElement());
        System.out.println("lastElement(): " + vector.lastElement());
 
        Object[] rawCopy = new Object[vector.size()];
        vector.copyInto(rawCopy);                 // copyInto(Object[])
        System.out.println("copyInto() result: " + Arrays.toString(rawCopy));
        
        
        // 4. UPDATING ELEMENTS
        vector.set(0, "Pineapple");                // set(int, E)
        vector.setElementAt("Coconut", 1);          // setElementAt(E, int) - legacy
        System.out.println("\nAfter updates: " + vector);
 
        vector.replaceAll(s -> s.toUpperCase());    // replaceAll(UnaryOperator) - Java 8+
        System.out.println("After replaceAll (uppercase): " + vector);
        
        
        
        // 5. SEARCHING ELEMENTS
        System.out.println("\ncontains(\"MANGO\"): " + vector.contains("MANGO"));
        System.out.println("containsAll([\"MANGO\",\"KIWI\"]): " +
                vector.containsAll(Arrays.asList("MANGO", "KIWI")));
        System.out.println("indexOf(\"MANGO\"): " + vector.indexOf("MANGO"));
        System.out.println("indexOf(\"MANGO\", 5): " + vector.indexOf("MANGO", 5));
        System.out.println("lastIndexOf(\"MANGO\"): " + vector.lastIndexOf("MANGO"));
        System.out.println("lastIndexOf(\"MANGO\", 6): " + vector.lastIndexOf("MANGO", 6));
        
        
        // 6. SIZE / CAPACITY MANAGEMENT
        System.out.println("\nsize(): " + vector.size());
        System.out.println("capacity(): " + vector.capacity());
        System.out.println("isEmpty(): " + vector.isEmpty());
 
        vector.ensureCapacity(50); // ensureCapacity(int)
        System.out.println("After ensureCapacity(50), capacity(): " + vector.capacity());
 
        vector.trimToSize();  // trimToSize()trimToSize() reduces the vector's capacity to exactly match its current size.
        System.out.println("After trimToSize(), capacity(): " + vector.capacity());
 
        vector.setSize(vector.size() + 2);           // setSize(int) - pads with null
        System.out.println("After setSize(+2): " + vector);
 
        // remove the padded nulls we just added, to keep things clean for later steps
        while (vector.contains(null)) {
            vector.remove(null);
        }
        
        
        
        // 7. REMOVING ELEMENTS
        vector.remove("COCONUT");                   // remove(Object)
        System.out.println("\nAfter remove(\"COCONUT\"): " + vector);
 
        vector.remove(0);                            // remove(int) - by index
        System.out.println("After remove(0): " + vector);
 
        vector.removeElement("KIWI");                // removeElement(Object) - legacy
        System.out.println("After removeElement(\"KIWI\"): " + vector);
 
        if (!vector.isEmpty()) {
            vector.removeElementAt(0);                // removeElementAt(int) - legacy
            System.out.println("After removeElementAt(0): " + vector);
        }
 
        vector.removeIf(s -> s.startsWith("F"));      // removeIf(Predicate) - Java 8+
        System.out.println("After removeIf(startsWith \"F\"): " + vector);
 
        Vector<String> toRemoveAll = new Vector<>(Arrays.asList("DATE"));
        vector.add("DATE");
        System.out.println("First Adding DATE----------> " + vector);        
        vector.removeAll(toRemoveAll);                // removeAll(Collection)
        System.out.println("After removeAll([\"DATE\"]): " + vector);
 
        Vector<String> toRetain = new Vector<>(vector.subList(0, Math.min(2, vector.size())));
        System.out.println("Printing toRetain arr------> " + toRetain);
        Vector<String> retainDemo = new Vector<>(vector);
        System.out.println("Printing retainDemo arr before retainALL------> " + retainDemo);
        retainDemo.retainAll(toRetain);               // retainAll(Collection)
        System.out.println("retainAll() demo result: " + retainDemo);

        
        // 8. ITERATION
        System.out.println("\n-- for-each loop --");
        for (String s : vector) {
            System.out.println(" - " + s);
        }
 
        System.out.println("-- Iterator --");
        Iterator<String> it = vector.iterator();
        while (it.hasNext()) {
            System.out.println(" - " + it.next());
        }
 
        System.out.println("-- ListIterator (forward) --");
        ListIterator<String> lit = vector.listIterator();
        while (lit.hasNext()) {
            System.out.println(" - [" + lit.nextIndex() + "] " + lit.next());
        }
        
        System.out.println("-- ListIterator (backward, from end) --");
        ListIterator<String> litEnd = vector.listIterator(vector.size());
        while (litEnd.hasPrevious()) {
            System.out.println(" - [" + litEnd.previousIndex() + "] " + litEnd.previous());
        }
 
        System.out.println("-- Enumeration (legacy) --");
        Enumeration<String> en = vector.elements();
        while (en.hasMoreElements()) {
            System.out.println(" - " + en.nextElement());
        }
 
        System.out.println("-- forEach(Consumer) - Java 8+ --");
        vector.forEach(s -> System.out.println(" - " + s));
	
        
        // 9. SORTING - Java 8+
        Vector<String> sortDemo = new Vector<>(vector);
        sortDemo.sort(null);                          // natural ordering
        System.out.println("\nsort(null) -> " + sortDemo);
 
        sortDemo.sort(Collections.reverseOrder());     // custom Comparator
        System.out.println("sort(reverseOrder) -> " + sortDemo);
    
        
        // 10. CONVERSION
        Object[] objArray = vector.toArray();          // toArray()
        System.out.println("\ntoArray(): " + Arrays.toString(objArray));
 
        String[] strArray = vector.toArray(new String[0]); // toArray(T[])
        System.out.println("toArray(T[]): " + Arrays.toString(strArray));
	
        
        // 11. SUBLIST / SPLITERATOR
        if (vector.size() >= 2) {
            List<String> sub = vector.subList(0, 2);   // subList(int, int) subList() does not create a new vector.
            System.out.println("\nsubList(0,2): " + sub);
        }
        System.out.println("Elements in the array----> " + vector);
        System.out.println("spliterator() estimate size: " + vector.spliterator().estimateSize());
        
        
        // 12. CLONING / EQUALITY / HASHING
        @SuppressWarnings("unchecked") 
        //Upper annotation: means if we comments it the below line will 
        //show yellow line..to prevent that line we add this annotation
        Vector<String> cloned = (Vector<String>) vector.clone();  // clone()
        System.out.println("\nclone(): " + cloned);
        System.out.println("vector.equals(cloned): " + vector.equals(cloned));
        System.out.println("vector.hashCode() == cloned.hashCode(): " +
                (vector.hashCode() == cloned.hashCode()));
        
        
        // 13. CLEARING
        Vector<String> toClear = new Vector<>(vector);
        toClear.removeAllElements();                    // removeAllElements() - legacy clear
        System.out.println("\nAfter removeAllElements(): " + toClear + " | isEmpty: " + toClear.isEmpty());
 
        toClear.addAll(vector);
        System.out.println("Well after adding back all the elements---> " + toClear);
        toClear.clear();                                 // clear() - Collection style
        System.out.println("After clear(): " + toClear + " | isEmpty: " + toClear.isEmpty());
 
        
        // FINAL STATE (String vector demo)
        System.out.println("\nFinal working vector: " + vector);
        Vector<Integer> toStringArr = new Vector<>();
        toStringArr.add(1);
        toStringArr.add(2);
        toStringArr.add(null);
        toStringArr.add(null);
        System.out.println("The Integer array--->> " + toStringArr);
        System.out.println("toString(): " + toStringArr.toString());
        
        
        
        
        // 14. Collections UTILITY METHODS (not part of Vector itself, but
        //     commonly used with it) - demonstrated on a numeric Vector<Integer>
        //     so min/max/abs actually make sense.
        System.out.println("\n\n========== Collections utility methods on Vector<Integer> ==========");
        
        Vector<Integer> nums = new Vector<>(Arrays.asList(15, -4, 8, 42, -23, 8, 16, 4));
        System.out.println("\nOriginal numeric vector: " + nums);
        
        
        // ---- min / max ----
        System.out.println("Collections.max(nums): " + Collections.max(nums));
        System.out.println("Collections.min(nums): " + Collections.min(nums));
        // with a custom Comparator (e.g. by absolute value)
        System.out.println("Collections.max(nums, by abs value): " +
                Collections.max(nums, (a, b) -> Math.abs(a) - Math.abs(b)));
        System.out.println("Collections.min(nums, by abs value): " +
                Collections.min(nums, (a, b) -> Math.abs(a) - Math.abs(b)));
        
        
        
        // ---- abs (Math class - applied element-wise, since Vector has no abs()) ----
        Vector<Integer> absValues = new Vector<>();
        for (int n : nums) {
            absValues.add(Math.abs(n));
        }
        System.out.println("Absolute values (Math.abs applied element-wise): " + absValues);
        
        
        // ---- sum / average (via simple loop - no direct Vector/Collections method for these) ----
        int sum = 0;
        for (int n : nums) sum += n;
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average of elements: " + (sum / (double) nums.size()));
        
        
        // ---- sort / reverse ----
        Vector<Integer> sortedNums = new Vector<>(nums);
        
        Collections.sort(sortedNums);                       // ascending natural order
        System.out.println("\nCollections.sort() -> " + sortedNums);
        
        Collections.sort(sortedNums, Collections.reverseOrder()); // descending
        System.out.println("Collections.sort(reverseOrder()) -> " + sortedNums);
        
        Collections.reverse(sortedNums);                    // just reverses current order
        System.out.println("Collections.reverse() -> " + sortedNums);
        
        
        // ---- frequency ----
        System.out.println("\nCollections.frequency(nums, 8): " + Collections.frequency(nums, 8));

        
        
        // ---- binarySearch (list must be sorted first) ----
        Vector<Integer> forSearch = new Vector<>(nums);
        Collections.sort(forSearch);
        System.out.println("Sorted for search: " + forSearch);
        System.out.println("Collections.binarySearch(forSearch, 16): " + Collections.binarySearch(forSearch, 16));
        
        
        // ---- swap ----
        Vector<Integer> swapDemo = new Vector<>(nums);
        System.out.println("\nWithout Swap(0, last) -> " + swapDemo);
        
        Collections.swap(swapDemo, 0, swapDemo.size() - 1);
        System.out.println("\nCollections.swap(0, last) -> " + swapDemo);
        
        
        // ---- rotate ----
        Vector<Integer> rotateDemo = new Vector<>(nums);
        System.out.println("\nWithout Rotate(distance=2) -> " + rotateDemo);
        
        Collections.rotate(rotateDemo, 2);
        System.out.println("Collections.rotate(distance=2) 2stepsRightSide -> " + rotateDemo);
        
        
        // ---- fill ----
        Vector<Integer> fillDemo = new Vector<>(nums);
        Collections.fill(fillDemo, 0);
        System.out.println("\nCollections.fill(0) -> " + fillDemo);
        
        
        // ---- copy ----
        Vector<Integer> copySrc = new Vector<>(Arrays.asList(100, 200, 300));
        Vector<Integer> copyDest = new Vector<>(Arrays.asList(1, 2, 3, 4, 5));
        
        System.out.println("1st Arrray -> " + copySrc);
        System.out.println("2nd Arrray Before-> " + copyDest);
        
        Collections.copy(copyDest, copySrc);  // dest must be >= src size
        System.out.println("Collections.copy(dest, src) -> " + copyDest);
        
        
        // ---- replaceAll (Collections version - replaces by value, different from List.replaceAll) ----
        Vector<Integer> replaceDemo = new Vector<>(nums);
        System.out.println("\nElements in replaceDemo Before" + replaceDemo);
        Collections.replaceAll(replaceDemo, 8, 999);
        System.out.println("\nCollections.replaceAll(8 -> 999) -> " + replaceDemo);
        
        
        // ---- disjoint (true if no common elements) ----
        Vector<Integer> other = new Vector<>(Arrays.asList(1, 2, 3));
        System.out.println("Collections.disjoint(nums, [1,2,3]): " + Collections.disjoint(nums, other));
        
        
        // ---- nCopies (creates an immutable list with n copies of an element) ----
        System.out.println("Collections.nCopies(3, \"X\"): " + Collections.nCopies(3, "X"));
 
        
        Vector<String> numms = new Vector<>(Collections.nCopies(4,"HiteshPatwal"));
        System.out.println("\nNCopies array---> " +  numms); 
	}

}
