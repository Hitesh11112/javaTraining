/**
 * StackOperations.java
 *
 * Complete demonstration of every public method available on java.util.Stack,
 * plus the Collections utility methods (min, max, sort, etc.) commonly used with it.
 *
 * IMPORTANT NOTE ON Stack:
 * - Stack extends Vector, meaning it IS ordered, indexed, and allows duplicates.
 * - Stack is thread-safe (synchronized), which introduces performance overhead.
 *   For modern applications, Deque (e.g., ArrayDeque) is generally preferred.
 * - Because it extends Vector, it supports all index-based methods like get(int), 
 *   set(int, E), and indexOf(), alongside traditional LIFO (Last-In-First-Out) operations.
 * - Direct index-based Collection utilities (sort, swap, rotate, binarySearch, etc.) 
 *   WORK directly on a Stack without needing to convert it to a List first.
 */

package DayWiseAssignment.Day_6July;

import java.util.Stack;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Collections;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class StackMain {

	public static void main(String[] args) {
		
		// 1. CONSTRUCTORS


        Stack<String> stack = new Stack<>();                            // default empty constructor
        
        // Note: Stack does not have a native collection-constructor, 
        // but we can addAll from an existing collection.
        Stack<String> stackFromCollection = new Stack<>();
        stackFromCollection.addAll(Arrays.asList("X", "Y", "Z"));

        System.out.println("stackFromCollection: " + stackFromCollection);

        // 2. ADDING ELEMENTS


        stack.push("Apple");                       // push(E) - Traditional LIFO add (returns the item)
        stack.push("Banana");
        boolean addedAgain = stack.add("Apple");    // add(E) - Vector method (returns true, allows duplicates)
        System.out.println("\nTrying to add \"Apple\" again -> add() returned: " + addedAgain);

        stack.addAll(Arrays.asList("Mango", "Kiwi", "Orange"));  // addAll(Collection)
        stack.add(2, "Grapes");                     // add(int index, E) - inserts at specific position

        System.out.println("After all add operations: " + stack);
        System.out.println("(Note: index 0 is the bottom of the stack, highest index is the top)");

        // 3. SEARCHING ELEMENTS


        System.out.println("\ncontains(\"Mango\"): " + stack.contains("Mango"));
        System.out.println("containsAll([\"Mango\",\"Kiwi\"]): " +
                stack.containsAll(Arrays.asList("Mango", "Kiwi")));

        // 1-based distance from the top of the stack (returns -1 if not found)
        System.out.println("search(\"Banana\"): " + stack.search("Banana")); 
        
        System.out.println("indexOf(\"Apple\") [From Bottom]: " + stack.indexOf("Apple"));
        System.out.println("lastIndexOf(\"Apple\") [From Bottom]: " + stack.lastIndexOf("Apple"));

        // 4. SIZE / EMPTY CHECK


        System.out.println("\nsize(): " + stack.size());
        System.out.println("empty(): " + stack.empty()); // Stack specific method
        System.out.println("isEmpty(): " + stack.isEmpty()); // Vector heritage method

        // 5. REMOVING ELEMENTS


        // Traditional LIFO peek and pop
        System.out.println("\npeek() [Look at top element without removing]: " + stack.peek());
        System.out.println("pop() [Remove and return top element]: " + stack.pop());
        System.out.println("After pop(): " + stack);

        stack.remove("Kiwi");                          // remove(Object)
        System.out.println("After remove(\"Kiwi\"): " + stack);

        stack.remove(1);                               // remove(int index)
        System.out.println("After remove(at index 1): " + stack);

        stack.removeIf(s -> s.startsWith("O"));         // removeIf(Predicate) - Java 8+
        System.out.println("After removeIf(startsWith \"O\"): " + stack);

        Stack<String> toRemoveAll = new Stack<>();
        toRemoveAll.push("Banana");
        stack.removeAll(toRemoveAll);                   // removeAll(Collection)
        System.out.println("After removeAll([\"Banana\"]): " + stack);

        Stack<String> retainDemo = new Stack<>();
        retainDemo.addAll(stackFromCollection);
        retainDemo.retainAll(Arrays.asList("X", "Y")); // retainAll(Collection) - keeps only matches
        System.out.println("retainAll([\"X\",\"Y\"]) demo result: " + retainDemo);

        // 6. ITERATION

        // rebuild stack with a few elements for iteration demo
        stack.addAll(Arrays.asList("Grapes", "Fig", "Date"));
        System.out.println("\nStack for iteration demo: " + stack);

        System.out.println("-- for-each loop (Iterates from bottom to top) --");
        for (String s : stack) {
            System.out.println(" - " + s);
        }

        System.out.println("-- Iterator --");
        Iterator<String> it = stack.iterator();
        while (it.hasNext()) {
            System.out.println(" - " + it.next());
        }

        System.out.println("-- ListIterator (Forward and Backward support) --");
        ListIterator<String> listIt = stack.listIterator();
        System.out.println("   Moving Forward:");
        while (listIt.hasNext()) {
            System.out.println("    - " + listIt.next());
        }
        System.out.println("   Moving Backward:");
        while (listIt.hasPrevious()) {
            System.out.println("    - " + listIt.previous());
        }

        System.out.println("-- forEach(Consumer) - Java 8+ --");
        stack.forEach(s -> System.out.println(" - " + s));

        // 7. CONVERSION


        Object[] objArray = stack.toArray();             // toArray()
        System.out.println("\ntoArray(): " + Arrays.toString(objArray));

        String[] strArray = stack.toArray(new String[0]); // toArray(T[])
        System.out.println("toArray(T[]): " + Arrays.toString(strArray));

        // 8. CLONING / EQUALITY / HASHING


        @SuppressWarnings("unchecked")
        Stack<String> cloned = (Stack<String>) stack.clone();  // clone()
        System.out.println("\nclone(): " + cloned);
        System.out.println("stack.equals(cloned): " + stack.equals(cloned));
        System.out.println("stack.hashCode() == cloned.hashCode(): " +
                (stack.hashCode() == cloned.hashCode()));

        // 9. CLEARING


        Stack<String> toClear = new Stack<>();
        toClear.addAll(stack);
        toClear.clear();                                // clear()
        System.out.println("\nAfter clear(): " + toClear + " | empty: " + toClear.empty());

        // FINAL STATE (String stack demo)


        System.out.println("\nFinal working stack: " + stack);
        System.out.println("toString(): " + stack.toString());

        // 10. Collections UTILITY METHODS


        System.out.println("\n\n========== Collections utility methods on Stack<Integer> ==========");

        Stack<Integer> nums = new Stack<>();
        nums.addAll(Arrays.asList(15, -4, 8, 42, -23, 16, 4));
        System.out.println("\nOriginal numeric stack: " + nums);

        // ---- min / max ----
        System.out.println("\nCollections.max(nums): " + Collections.max(nums));
        System.out.println("Collections.min(nums): " + Collections.min(nums));
        System.out.println("Collections.max(nums, by abs value): " +
                Collections.max(nums, (a, b) -> Math.abs(a) - Math.abs(b)));
        System.out.println("Collections.min(nums, by abs value): " +
                Collections.min(nums, (a, b) -> Math.abs(a) - Math.abs(b)));

        // ---- abs (Math class - applied element-wise) ----
        Stack<Integer> absValues = new Stack<>();
        for (int n : nums) {
            absValues.push(Math.abs(n));
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
        Stack<Integer> other = new Stack<>();
        other.addAll(Arrays.asList(1, 2, 3));
        System.out.println("Collections.disjoint(nums, [1,2,3]): " + Collections.disjoint(nums, other));

        // ---- sort / reverse / swap / rotate / binarySearch / fill / copy ----
        // Unlike Sets, Stack inherits index support from Vector. These work natively!
        
        Collections.sort(nums);
        System.out.println("\nCollections.sort() -> " + nums);

        Collections.sort(nums, Collections.reverseOrder());
        System.out.println("Collections.sort(reverseOrder()) -> " + nums);

        Collections.reverse(nums);
        System.out.println("Collections.reverse() -> " + nums);

        Collections.sort(nums); // Sort again for binary search
        System.out.println("\nSorted for search: " + nums);
        System.out.println("Collections.binarySearch(nums, 16): " +
                Collections.binarySearch(nums, 16));

        Collections.swap(nums, 0, nums.size() - 1);
        System.out.println("\nCollections.swap(0, last) -> " + nums);

        Collections.rotate(nums, 2);
        System.out.println("Collections.rotate(distance=2) -> " + nums);

        Stack<Integer> fillDemo = new Stack<>();
        fillDemo.addAll(nums);
        Collections.fill(fillDemo, 0);
        System.out.println("Collections.fill(0) -> " + fillDemo);

        List<Integer> copySrc = new ArrayList<>(Arrays.asList(100, 200, 300));
        Stack<Integer> copyDest = new Stack<>();
        copyDest.addAll(Arrays.asList(1, 2, 3, 4, 5));
        Collections.copy(copyDest, copySrc);
        System.out.println("Collections.copy(destStack, srcList) -> " + copyDest);


        // ---- synchronizedList wrapper ----
        List<Integer> syncList = Collections.synchronizedList(nums);
        System.out.println("Collections.synchronizedList() wrapper created: " + syncList);

        // ---- emptyList view ----
        List<Integer> empty = Collections.emptyList();
        System.out.println("Collections.emptyList(): " + empty);

		
	}

}
