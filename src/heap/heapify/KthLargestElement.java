package heap.heapify;

import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement {
    public static void main(String[] args) {
        int arr[] = { 11, 3, 2, 1, 15, 5, 4, 45, 88, 96, 50, 45 };
        int k = 4;
        printKthLargestElement(arr,k);
    }

    private static void printKthLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i : arr) {
            minHeap.add(i);
            if (minHeap.size() > k) {
                minHeap.poll(); // Remove the smallest element
            }
        }
        System.out.println("Kth Largest Element is : "+minHeap.peek());
    }

}
