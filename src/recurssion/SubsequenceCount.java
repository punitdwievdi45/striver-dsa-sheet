package recurssion;

public class SubsequenceCount {
    public static void main(String[] args) {
        int arr[] = {1,2,1};
        int k =3;
        System.out.println(printSubCount(0,arr,k, arr.length, 0));
    }

    private static int printSubCount(int ind, int[] arr, int k, int length, int sum) {
        if (ind == length){
            if (sum == k){
                return 1;
            }
            return 0;
        }
        sum = sum+arr[ind];
        int left = printSubCount(ind+1,arr,k,length,sum);
        sum = sum - arr[ind];
        int right = printSubCount(ind+1,arr,k,length,sum);
        return left+right;
    }
}
