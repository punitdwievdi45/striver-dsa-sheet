package heap.heapify;

import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {
    public static void main(String[] args) {
        int arr[] = {2, 7, 4, 1, 8, 1};
        int leftOver = lastStone(arr, arr.length);
        System.out.println("The Left Over is : " + leftOver);
    }

    private static int lastStone(int[] arr, int length) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : arr) {
            maxHeap.add(i);
        }
        int first, second;
        while (maxHeap.size() > 1) {
            first = maxHeap.poll();
            second = maxHeap.poll();
            if (first != second) {
                maxHeap.add(first - second);
            }
        }
        return !maxHeap.isEmpty() ? maxHeap.poll() : 0;
    }
}
