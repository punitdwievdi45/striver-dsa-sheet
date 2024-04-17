package striversheet.array;

import java.util.HashMap;
import java.util.Map;

public class NumberOccurence {
    public static void main(String[] args) {
        int arr[] = {2,1,2,1,4,2};
        printElementOccurence(arr);
    }

    private static void printElementOccurence(int[] arr) {
        Map<Integer,Integer> hashMap = new HashMap<>();
        for (int i : arr){
            if (hashMap.containsKey(i)){
                hashMap.put(i, hashMap.get(i)+1);
            }
            else{
                hashMap.put(i,1);
            }
        }
        System.out.println("HashMap is : "+ hashMap);
    }

}
