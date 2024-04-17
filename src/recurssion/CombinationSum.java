package recurssion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        System.out.println(combinationSum());
    }

    public static List<List<Integer>> combinationSum() {
        int arr[] = {2, 3, 6, 7};
        List<List<Integer>> ans = new ArrayList<>();
        findSumComb(0, arr, new ArrayList<>(), 7, ans);
        return ans;
    }

    private static void findSumComb(int ind, int[] arr, ArrayList<Integer> ds, int target, List<List<Integer>> ans) {
        if (ind == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if (arr[ind] <= target) {
            ds.add(arr[ind]);
            findSumComb(ind, arr, ds, target - arr[ind], ans);
            ds.remove(ds.size() - 1);
        }
        findSumComb(ind + 1, arr, ds, target, ans);
    }
}
