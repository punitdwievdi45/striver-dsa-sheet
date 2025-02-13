package heap.heapify;

public class BuildMaxHeap {
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int N = arr.length;

        sort(arr);

        System.out.println("Sorted array is");

        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    private static void sort(int[] arr) {

        int N = arr.length;

        // build heap
        for (int i = N / 2 - 1; i >= 0; i--) {
            heapify(arr, N, i);
        }

        // One by one extract an element from heap
        for (int i = N - 1; i > 0; i--) {
            // Move current root to end
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    private static void heapify(int[] arr, int N, int i) {
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if (leftChild < N && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }
        if (rightChild < N && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            heapify(arr, N, i);
        }
    }
}
