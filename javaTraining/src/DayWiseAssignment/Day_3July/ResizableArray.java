/*
 * Resize-able Array
 */

package DayWiseAssignment.Day_3July;

public class ResizableArray {
	private int[] arr;
    private int size;

    // Constructor
    public ResizableArray() {
        arr = new int[2];
        size = 0;
    }

    // Add element
    public void add(int value) {
        if (size == arr.length) {
            resize();
        }
        arr[size++] = value;
    }

    // Resize array
    private void resize() {
        int[] newArr = new int[arr.length * 2];

        for (int i = 0; i < arr.length; i++) newArr[i] = arr[i];
        arr = newArr;
    }

    // Size
    public int size() {
        return size;
    }

    public static void main(String[] args) {

        ResizableArray list = new ResizableArray();

        list.add(10);
        list.add(20);
        list.add(30); // Resizes here
        list.add(40);
        list.add(50);

        System.out.println("Size: " + list.size());
    }
}