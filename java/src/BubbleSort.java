package src;

public class BubbleSort {
    public void bubble_sort(int[] arr) {
        // Loop through the entire array.
        for (int i = 0; i < arr.length; ++i) {
            // Loop through the entire array again, but stop one element short.
            for (int j = 0; j < arr.length - 1; ++j) {
                // If the current element is greater than the next element, swap them.
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
