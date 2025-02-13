package heap.heapify;

public class HeapifyAlgo {
    public static void main(String[] args) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int N = arr.length;

        // Function call
        maxHeap(arr, 0);

        System.out.println("Sorted array is");
        //printArray(arr);
        for (int i : arr){
            System.out.print(i+" ");
        }
    }

    private static void maxHeap(int[] arr, int i) {
        int leftChild = 2*i + 1;
        int rightChild = 2 * i+2;
        int largest = i;
        if(leftChild < arr.length && arr[leftChild] > arr[i]){
            largest = leftChild;
        }
        else {
            largest = i;
        }
        if(rightChild < arr.length && arr[rightChild] > arr[largest]){
            largest = rightChild;
        }
        if ((largest != i)){
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            maxHeap(arr, largest);
        }
    }

}
