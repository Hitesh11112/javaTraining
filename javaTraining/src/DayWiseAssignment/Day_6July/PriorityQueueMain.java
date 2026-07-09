/**
 * PriorityQueueOperations.java
 *
 * Complete demonstration of every public method available on java.util.PriorityQueue,
 * plus the Collections utility methods (min, max, sort, etc.) commonly used with it.
 *
 * IMPORTANT NOTE ON PriorityQueue:
 * - PriorityQueue is an unbounded queue based on a priority heap. Elements are ordered 
 *   according to their natural ordering, or by a Comparator provided at queue construction time.
 * - PriorityQueue does NOT allow null elements (throws NullPointerException).
 * - PriorityQueue does ALLOW duplicate elements.
 * - The Iterator provided by this class does NOT guarantee to traverse the elements of the 
 *   PriorityQueue in any particular order. To traverse in sorted priority order, use Arrays.sort(pq.toArray()) 
 *   or repeatedly call poll().
 * - PriorityQueue has NO index-based methods: no get(int), set(int, E), add(int, E), etc.
 * - Because there's no index, methods like Collections.sort(), Collections.swap(),
 *   Collections.rotate(), Collections.binarySearch(), Collections.fill(), and
 *   Collections.copy() do NOT work directly on a Queue - you must first convert it
 *   to a List (e.g., new ArrayList<>(pq)).
 */

package DayWiseAssignment.Day_6July;

import java.util.PriorityQueue;
import java.util.Iterator;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
public class PriorityQueueMain {
	
	public static void main(String[] args) {
		
		
		// 1. CONSTRUCTORS
        PriorityQueue<String> pq = new PriorityQueue<>();                           // default capacity (11), natural ordering
        PriorityQueue<String> pqCap = new PriorityQueue<>(32);                       // initial capacity
        PriorityQueue<String> pqWithComparator = new PriorityQueue<>(11, Collections.reverseOrder()); // capacity + custom comparator
        PriorityQueue<String> pqFromCollection = new PriorityQueue<>(Arrays.asList("Z", "Y", "X")); // from Collection

        System.out.println("pqFromCollection: " + pqFromCollection);

        
        // 2. ADDING ELEMENTS
        pq.add("Apple");                            // add(E) - inserts element, returns true (throws exception if full, though unbounded)
        pq.offer("Banana");                         // offer(E) - preferred Queue method for insertion, returns true
        
        // Adding a duplicate element (allowed in PriorityQueue)
        pq.offer("Apple"); 
        
        pq.addAll(Arrays.asList("Mango", "Kiwi", "Orange"));  // addAll(Collection)

        System.out.println("After all add operations: " + pq);
        System.out.println("(Note: The internal layout shown by toString() is a heap array representation, NOT sorted order)");

        
        // 3. SEARCHING ELEMENTS
        System.out.println("\ncontains(\"Mango\"): " + pq.contains("Mango"));
        System.out.println("containsAll([\"Mango\",\"Kiwi\"]): " +
                pq.containsAll(Arrays.asList("Mango", "Kiwi")));

        // NOTE: There is no indexOf()/lastIndexOf() - PriorityQueue has no accessible positions/index.

        
        // 4. SIZE / EMPTY CHECK
        System.out.println("\nsize(): " + pq.size());
        System.out.println("isEmpty(): " + pq.isEmpty());

        
        // 5. REMOVING / RETRIEVING ELEMENTS (QUEUE SPECIFIC)
        // Peek operations (examines the head of the queue without removing)
        System.out.println("\npeek(): " + pq.peek()); // returns null if empty
        System.out.println("element(): " + pq.element()); // throws NoSuchElementException if empty

        // Poll/Remove operations (retrieves and removes the highest priority element)
        System.out.println("poll(): " + pq.poll()); // returns null if empty
        System.out.println("After poll(), current head is: " + pq.peek());

        System.out.println("remove(): " + pq.remove()); // throws NoSuchElementException if empty
        System.out.println("After remove(), remaining queue: " + pq);

        // Standard Collection structural removals
        pq.remove("Kiwi");                          // remove(Object) - removes a single instance if present
        System.out.println("After remove(\"Kiwi\"): " + pq);

        pq.removeIf(s -> s.startsWith("O"));         // removeIf(Predicate) - Java 8+
        System.out.println("After removeIf(startsWith \"O\"): " + pq);

        PriorityQueue<String> toRemoveAll = new PriorityQueue<>(Arrays.asList("Banana"));
        pq.removeAll(toRemoveAll);                   // removeAll(Collection)
        System.out.println("After removeAll([\"Banana\"]): " + pq);

        PriorityQueue<String> retainDemo = new PriorityQueue<>(pqFromCollection);
        retainDemo.retainAll(Arrays.asList("X", "Y")); // retainAll(Collection) - keeps only matches
        System.out.println("retainAll([\"X\",\"Y\"]) demo result: " + retainDemo);


        // 6. ITERATION
        // rebuild queue with a few elements for iteration demo
        pq.addAll(Arrays.asList("Grapes", "Fig", "Date"));
        System.out.println("\nQueue for iteration demo: " + pq);

        System.out.println("-- for-each loop (Warning: order is arbitrary, NOT priority order) --");
        for (String s : pq) {
            System.out.println(" - " + s);
        }

        System.out.println("-- Iterator (Warning: order is arbitrary, NOT priority order) --");
        Iterator<String> it = pq.iterator();
        while (it.hasNext()) {
            System.out.println(" - " + it.next());
        }

        System.out.println("-- Proper Priority Order Iteration (Destructive via poll()) --");
        PriorityQueue<String> destructiveCopy = new PriorityQueue<>(pq);
        while (!destructiveCopy.isEmpty()) {
            System.out.println(" - " + destructiveCopy.poll());
        }

        System.out.println("-- forEach(Consumer) - Java 8+ (Warning: order is arbitrary) --");
        pq.forEach(s -> System.out.println(" - " + s));


        // 7. CONVERSION
        Object[] objArray = pq.toArray();             // toArray()
        System.out.println("\ntoArray(): " + Arrays.toString(objArray));

        String[] strArray = pq.toArray(new String[0]); // toArray(T[])
        System.out.println("toArray(T[]): " + Arrays.toString(strArray));

        
        // 8. CLONING / EQUALITY / HASHING
        // Note: PriorityQueue does NOT implement Cloneable natively or override Object.equals() / hashCode().
        // It relies on standard reference equality / identity hashcodes from Object.
        System.out.println("\npq.equals(pq) [Reference equality]: " + pq.equals(pq));

        
        // 9. CLEARING
        PriorityQueue<String> toClear = new PriorityQueue<>(pq);
        toClear.clear();                                // clear()
        System.out.println("\nAfter clear(): " + toClear + " | isEmpty: " + toClear.isEmpty());

        // FINAL STATE (String queue demo)
        System.out.println("\nFinal working queue: " + pq);
        System.out.println("toString(): " + pq.toString());

        
        // 10. Collections UTILITY METHODS
        System.out.println("\n\n========== Collections utility methods on PriorityQueue<Integer> ==========");

        PriorityQueue<Integer> nums = new PriorityQueue<>(Arrays.asList(15, -4, 8, 42, -23, 16, 4));
        System.out.println("\nOriginal numeric queue: " + nums);

        // ---- min / max (work directly on Queue - just needs Collection) ----
        System.out.println("\nCollections.max(nums): " + Collections.max(nums));
        System.out.println("Collections.min(nums): " + Collections.min(nums));
        System.out.println("Collections.max(nums, by abs value): " +
                Collections.max(nums, (a, b) -> Math.abs(a) - Math.abs(b)));
        System.out.println("Collections.min(nums, by abs value): " +
                Collections.min(nums, (a, b) -> Math.abs(a) - Math.abs(b)));

        // ---- abs (Math class - applied element-wise) ----
        PriorityQueue<Integer> absValues = new PriorityQueue<>();
        for (int n : nums) {
            absValues.add(Math.abs(n));
        }
        System.out.println("Absolute values (Math.abs applied element-wise): " + absValues);

        // ---- sum / average (via simple loop) ----
        int sum = 0;
        for (int n : nums) sum += n;
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average of elements: " + (sum / (double) nums.size()));

        // ---- frequency ----
        System.out.println("\nCollections.frequency(nums, 8): " + Collections.frequency(nums, 8));

        // ---- disjoint ----
        PriorityQueue<Integer> other = new PriorityQueue<>(Arrays.asList(1, 2, 3));
        System.out.println("Collections.disjoint(nums, [1,2,3]): " + Collections.disjoint(nums, other));

        // ---- sort / reverse / swap / rotate / binarySearch / fill / copy ----
        // These require a List, since a Queue has no defined index positions.
        // Convert first:
        List<Integer> sortedNums = new ArrayList<>(nums);
        Collections.sort(sortedNums);
        System.out.println("\n[Converted to List first] Collections.sort() -> " + sortedNums);

        Collections.sort(sortedNums, Collections.reverseOrder());
        System.out.println("[Converted to List first] Collections.sort(reverseOrder()) -> " + sortedNums);

        Collections.reverse(sortedNums);
        System.out.println("[Converted to List first] Collections.reverse() -> " + sortedNums);

        List<Integer> forSearch = new ArrayList<>(nums);
        Collections.sort(forSearch);
        System.out.println("\n[Converted to List first] Sorted for search: " + forSearch);
        System.out.println("Collections.binarySearch(forSearch, 16): " +
                Collections.binarySearch(forSearch, 16));

        List<Integer> swapDemo = new ArrayList<>(nums);
        Collections.swap(swapDemo, 0, swapDemo.size() - 1);
        System.out.println("\n[Converted to List first] Collections.swap(0, last) -> " + swapDemo);

        List<Integer> rotateDemo = new ArrayList<>(nums);
        Collections.rotate(rotateDemo, 2);
        System.out.println("[Converted to List first] Collections.rotate(distance=2) -> " + rotateDemo);

        List<Integer> fillDemo = new ArrayList<>(nums);
        Collections.fill(fillDemo, 0);
        System.out.println("[Converted to List first] Collections.fill(0) -> " + fillDemo);

        List<Integer> copySrc = new ArrayList<>(Arrays.asList(100, 200, 300));
        List<Integer> copyDest = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        Collections.copy(copyDest, copySrc);
        System.out.println("[Converted to List first] Collections.copy(dest, src) -> " + copyDest);		
		
	}

}
