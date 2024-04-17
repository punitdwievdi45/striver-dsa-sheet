package recurssion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortPrinter {

    public static void main(String[] args) {
        int arr[] = {1, 2, 0, 4, 3};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid + 1, high);
        merge(arr, low, high, mid);
    }

    private static void merge(int[] arr, int low, int high, int mid) {
        int left = low;
        int right = mid + 1;
        List<Integer> list = new ArrayList<>();
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                list.add(arr[left++]);
            } else {
                list.add(arr[right++]);
            }

        }
        while (left <= mid) {
            list.add(arr[left++]);
        }
        while (right <= high) {
            list.add(arr[right++]);
        }
        for (int i = low; i <= high; i++) {
            arr[i] = list.get(i - low);
        }
    }

}
