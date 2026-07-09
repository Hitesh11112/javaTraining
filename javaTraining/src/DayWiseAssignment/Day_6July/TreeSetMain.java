/**
 * TreeSetOperations.java
 *
 * Complete demonstration of every public method available on java.util.TreeSet,
 * plus the Collections utility methods (min, max, sort, etc.) commonly used with it.
 *
 * IMPORTANT NOTE ON TreeSet:
 * - TreeSet MAINTAINS elements in sorted, natural order (or by a custom Comparator)[cite: 1].
 * - TreeSet does NOT allow duplicate elements - adding a duplicate is silently ignored[cite: 1].
 * - TreeSet does NOT allow null elements (throws NullPointerException on natural order).
 * - TreeSet has NO index-based methods: no get(int), set(int, E), add(int, E),
 *   indexOf(), lastIndexOf(), or ListIterator[cite: 1]. It implements NavigableSet/Set,
 *   not List[cite: 1].
 * - Because there's no index, methods like Collections.sort(), Collections.swap(),
 *   Collections.rotate(), Collections.binarySearch(), Collections.fill(), and
 *   Collections.copy() do NOT work directly on a Set - you must first convert it
 *   to a List (e.g., new ArrayList<>(set))[cite: 1].
 */

package DayWiseAssignment.Day_6July;

import java.util.TreeSet;
import java.util.Iterator;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.NavigableSet;

public class TreeSetMain {
	
	public static void main(String[] args) {
		
		// 1. CONSTRUCTORS


        TreeSet<String> set = new TreeSet<>();                          // natural ordering
        TreeSet<String> setWithComparator = new TreeSet<>(Collections.reverseOrder()); // custom comparator
        TreeSet<String> setFromCollection = new TreeSet<>(Arrays.asList("Z", "Y", "X")); // from Collection

        System.out.println("setFromCollection (automatically sorted): " + setFromCollection);

        // 2. ADDING ELEMENTS


        set.add("Apple");                          // add(E) - returns boolean (true if added, false if duplicate)
        set.add("Banana");
        boolean addedAgain = set.add("Apple");      // duplicate - will be ignored
        System.out.println("\nTrying to add \"Apple\" again -> add() returned: " + addedAgain);

        set.addAll(Arrays.asList("Mango", "Kiwi", "Orange"));  // addAll(Collection)

        System.out.println("After all add operations: " + set);
        System.out.println("(Note: order shown IS sorted alphabetical order - TreeSet guarantees sorted order)");

        // 3. SEARCHING ELEMENTS


        System.out.println("\ncontains(\"Mango\"): " + set.contains("Mango"));
        System.out.println("containsAll([\"Mango\",\"Kiwi\"]): " +
                set.containsAll(Arrays.asList("Mango", "Kiwi")));

        // NOTE: There is no indexOf()/lastIndexOf() - TreeSet has no positions/index.

        // 4. SIZE / EMPTY CHECK


        System.out.println("\nsize(): " + set.size());
        System.out.println("isEmpty(): " + set.isEmpty());

        // 5. REMOVING ELEMENTS


        set.remove("Kiwi");                          // remove(Object)
        System.out.println("\nAfter remove(\"Kiwi\"): " + set);

        set.removeIf(s -> s.startsWith("O"));         // removeIf(Predicate) - Java 8+
        System.out.println("After removeIf(startsWith \"O\"): " + set);

        TreeSet<String> toRemoveAll = new TreeSet<>(Arrays.asList("Banana"));
        set.removeAll(toRemoveAll);                   // removeAll(Collection)
        System.out.println("After removeAll([\"Banana\"]): " + set);

        TreeSet<String> retainDemo = new TreeSet<>(setFromCollection);
        retainDemo.retainAll(Arrays.asList("X", "Y")); // retainAll(Collection) - keeps only matches
        System.out.println("retainAll([\"X\",\"Y\"]) demo result: " + retainDemo);

        // 5.5 TreeSet / NavigableSet SPECIFIC NAVIGATION METHODS


        System.out.println("\nFirst element: " + set.first());
        System.out.println("Last element: " + set.last());
        
        System.out.println("Lower than 'Mango' (<): " + set.lower("Mango"));
        System.out.println("Floor of 'Mango' (<=): " + set.floor("Mango"));
        System.out.println("Ceiling of 'Banana' (>=): " + set.ceiling("Banana"));
        System.out.println("Higher than 'Banana' (>): " + set.higher("Banana"));

        // Creating subsets
        System.out.println("SubSet (Apple to Mango): " + set.subSet("Apple", "Mango"));
        System.out.println("HeadSet (up to Mango): " + set.headSet("Mango"));
        System.out.println("TailSet (from Mango onwards): " + set.tailSet("Mango"));

        // Descending view
        NavigableSet<String> descendingSet = set.descendingSet();
        System.out.println("Descending Set view: " + descendingSet);

        // Polling elements (removes and returns)
        TreeSet<String> pollDemo = new TreeSet<>(set);
        System.out.println("Polled First: " + pollDemo.pollFirst() + " | Remaining: " + pollDemo);
        System.out.println("Polled Last: " + pollDemo.pollLast() + " | Remaining: " + pollDemo);

        // 6. ITERATION


        // rebuild set with a few elements for iteration demo
        set.addAll(Arrays.asList("Grapes", "Fig", "Date"));
        System.out.println("\nSet for iteration demo: " + set);

        System.out.println("-- for-each loop --");
        for (String s : set) {
            System.out.println(" - " + s);
        }

        System.out.println("-- Iterator (also supports safe removal during iteration) --");
        Iterator<String> it = set.iterator();
        while (it.hasNext()) {
            String val = it.next();
            System.out.println(" - " + val);
        }

        System.out.println("-- Descending Iterator --");
        Iterator<String> descIt = set.descendingIterator();
        while (descIt.hasNext()) {
            System.out.println(" - " + descIt.next());
        }

        System.out.println("-- forEach(Consumer) - Java 8+ --");
        set.forEach(s -> System.out.println(" - " + s));

        // NOTE: There is NO ListIterator for a TreeSet (only List has that).

        // 7. CONVERSION


        Object[] objArray = set.toArray();             // toArray()
        System.out.println("\ntoArray(): " + Arrays.toString(objArray));

        String[] strArray = set.toArray(new String[0]); // toArray(T[])
        System.out.println("toArray(T[]): " + Arrays.toString(strArray));

        // 8. CLONING / EQUALITY / HASHING


        @SuppressWarnings("unchecked")
        TreeSet<String> cloned = (TreeSet<String>) set.clone();  // clone()
        System.out.println("\nclone(): " + cloned);
        System.out.println("set.equals(cloned): " + set.equals(cloned));
        System.out.println("set.hashCode() == cloned.hashCode(): " +
                (set.hashCode() == cloned.hashCode()));

        // 9. CLEARING


        TreeSet<String> toClear = new TreeSet<>(set);
        toClear.clear();                                // clear()
        System.out.println("\nAfter clear(): " + toClear + " | isEmpty: " + toClear.isEmpty());

        // FINAL STATE (String set demo)


        System.out.println("\nFinal working set: " + set);
        System.out.println("toString(): " + set.toString());

        // 10. Collections UTILITY METHODS


        System.out.println("\n\n========== Collections utility methods on TreeSet<Integer> ==========");

        TreeSet<Integer> nums = new TreeSet<>(Arrays.asList(15, -4, 8, 42, -23, 16, 4));
        System.out.println("\nOriginal numeric set: " + nums);
        System.out.println("(Note: 8 appears only once even though inserted twice - Set enforces uniqueness)");

        // ---- min / max (work directly on Set - just needs Collection) ----
        System.out.println("\nCollections.max(nums): " + Collections.max(nums));
        System.out.println("Collections.min(nums): " + Collections.min(nums));
        System.out.println("Collections.max(nums, by abs value): " +
                Collections.max(nums, (a, b) -> Math.abs(a) - Math.abs(b)));
        System.out.println("Collections.min(nums, by abs value): " +
                Collections.min(nums, (a, b) -> Math.abs(a) - Math.abs(b)));

        // ---- abs (Math class - applied element-wise) ----
        TreeSet<Integer> absValues = new TreeSet<>();
        for (int n : nums) {
            absValues.add(Math.abs(n));
        }
        System.out.println("Absolute values (Math.abs applied element-wise): " + absValues);

        // ---- sum / average (via simple loop) ----
        int sum = 0;
        for (int n : nums) sum += n;
        System.out.println("Sum of elements: " + sum);
        System.out.println("Average of elements: " + (sum / (double) nums.size()));

        // ---- frequency (works directly on Set, though always 0 or 1 since no duplicates) ----
        System.out.println("\nCollections.frequency(nums, 8): " + Collections.frequency(nums, 8));

        // ---- disjoint (works directly on Set - true if no common elements) ----
        TreeSet<Integer> other = new TreeSet<>(Arrays.asList(1, 2, 3));
        System.out.println("Collections.disjoint(nums, [1,2,3]): " + Collections.disjoint(nums, other));

        // ---- sort / reverse / swap / rotate / binarySearch / fill / copy ----
        // These require a List, since a Set has no defined order/index.
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

        // ---- shuffle (also needs a List) ----
        List<Integer> shuffleDemo = new ArrayList<>(nums);
        Collections.shuffle(shuffleDemo);
        System.out.println("\n[Converted to List first] Collections.shuffle() -> " + shuffleDemo +
                " (order will vary each run)");


        // ---- synchronizedSet (thread-safe wrapper - Set-specific version) ----
        Set<Integer> syncSet = Collections.synchronizedSet(nums);
        System.out.println("Collections.synchronizedSet() wrapper created: " + syncSet);

        // ---- emptySet ----
        Set<Integer> empty = Collections.emptySet();
        System.out.println("Collections.emptySet(): " + empty);		
	}
}



