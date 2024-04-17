package recurssion;

import java.util.ArrayList;
import java.util.List;

public class SubsequenceSum {
    public static void main(String[] args) {
        int arr[] = {1,2,1};
        int sum = 0;
        int k = 3;
        List<Integer> list = new ArrayList<>();
        printSumSubsequence(0, arr,sum,k, arr.length,list);
    }

    private static void printSumSubsequence(int ind, int[] arr, int sum, int k, int length, List<Integer> list) {
        if (ind == length){
            if (sum == k){
                System.out.println(list);
            }
            return;
        }
        list.add(arr[ind]);
        sum = sum + arr[ind];
        printSumSubsequence(ind+1,arr, sum, k,length,list);
        list.remove(list.size()-1);
        sum = sum - arr[ind];
        printSumSubsequence(ind+1,arr, sum, k,length,list);
    }
}
