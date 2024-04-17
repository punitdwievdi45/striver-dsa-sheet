package recurssion;

import java.util.ArrayList;
import java.util.List;

public class SubsequencePrinter {
    public static void main(String[] args) {
        int arr[] = {3,1,2};
        List<Integer> list = new ArrayList<>();
        printSubsequence(0, list, arr, arr.length);
    }

    private static void printSubsequence(int ind, List<Integer> list, int[] arr, int length) {
        if(ind == length){
            System.out.println(list);
            return;
        }
        list.add(arr[ind]);
        //take
        printSubsequence(ind+1, list, arr, length);
        list.remove(list.size()-1);
        //not take
        printSubsequence(ind+1,list,arr,length);
    }
}
