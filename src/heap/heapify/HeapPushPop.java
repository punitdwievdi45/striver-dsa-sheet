package heap.heapify;

import java.util.Arrays;

public class HeapPushPop {
    public static final int MAX_HEAP_SIZE = 7;

    public static void main(String[] args) {
        int arr[] = {8, 7, 5, 4, 3};
        int heapSize = arr.length;
        int[] heap = Arrays.copyOf(arr, MAX_HEAP_SIZE);
        heapSize = push_in_heap(heap, heapSize, 6);
        heapSize = push_in_heap(heap, heapSize, 9);
        System.out.println("Heap after insertion: " + Arrays.toString(Arrays.copyOf(heap, heapSize)));

        int maxElement = pop_from_heap(heap, heapSize);
        heapSize--;
        System.out.println("Heap after popping max element (" + maxElement + "): " + Arrays.toString(Arrays.copyOf(heap, heapSize)));

    }

    private static int push_in_heap(int[] heap, int heapSize, int val) {
        if (heapSize >= MAX_HEAP_SIZE) {
            System.out.println("Heap Overflow");
            return heapSize;
        }

        heap[heapSize] = val;
        int curr = heapSize;
        while (curr > 0 && heap[(curr - 1) / 2] < heap[curr]) {
            int swap = heap[(curr - 1) / 2];
            heap[(curr - 1) / 2] = heap[curr];
            heap[curr] = swap;
            curr = (curr - 1) / 2;
        }
        return heapSize + 1;
    }

    private static int pop_from_heap(int[] heap, int heapSize) {
        if (heapSize <= 0) {
            System.out.println("Heap Underflow");
            return Integer.MIN_VALUE;
        }

        // Get the maximum element from the heap (root of the heap)
        int maxElement = heap[0];

        // Move the last element to the root and reduce the heap size
        heap[0] = heap[heapSize - 1];
        heapSize--;

        // Heapify down from the root to maintain the heap property
        heapify_down(heap, heapSize, 0);

        return maxElement;
    }

    private static void heapify_down(int[] heap, int heapSize, int index) {
        int largest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        // Find the largest among root, left child and right child
        if (leftChild < heapSize && heap[leftChild] > heap[largest]) {
            largest = leftChild;
        }
        if (rightChild < heapSize && heap[rightChild] > heap[largest]) {
            largest = rightChild;
        }

        // Swap and continue heapifying if root is not the largest
        if (largest != index) {
            int swap = heap[index];
            heap[index] = heap[largest];
            heap[largest] = swap;

            heapify_down(heap, heapSize, largest);
        }
    }
}
