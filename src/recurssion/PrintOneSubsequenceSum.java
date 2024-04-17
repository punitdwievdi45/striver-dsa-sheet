package recurssion;

import java.util.ArrayList;
import java.util.List;

public class PrintOneSubsequenceSum {
    public static void main(String[] args) {
        int arr[] = {1, 2, 1};
        int sum = 0;
        int k = 3;
        List<Integer> list = new ArrayList<>();
        printOneSubSum(0, sum, arr, list, arr.length, k);
    }

    private static boolean printOneSubSum(int ind, int sum, int[] arr, List<Integer> list, int length, int k) {
        if (ind == length) {
            if (sum == k) {
                System.out.println(list);
                return true;
            }
            return false;
        }
        list.add(arr[ind]);
        sum = sum + arr[ind];
        if (printOneSubSum(ind + 1, sum, arr, list, length, k) == true) {
            return true;
        }
        list.remove(list.size() - 1);
        sum = sum - arr[ind];
        if (printOneSubSum(ind + 1, sum, arr, list, length, k) == true) {
            return true;
        }

        return false;
    }
}
