package src;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};
        
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.bubble_sort(arr);
        
        System.out.println("Sorted array:");
        System.out.println(Arrays.toString(arr));

        int[] haystack = {4, 2, 9, 6, 1, 8, 3};
        int needle = 6;
    
        boolean found = LinearSearchList.linearSearch(haystack, needle);
        //print found
        System.out.println(found);
    }
}