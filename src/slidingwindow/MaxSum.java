package slidingwindow;

public class MaxSum {
    public static void main(String[] args) throws Exception {
        int arr[] = {100, 200, 300, 400};
        int k = 2;
        naiveApproach(arr, k);
        //slidingTech(arr,k);
        // throw new Exception("Format"  +k+ + "is not supported"");
        //  System.out.println(arr.length);
    }

    private static void slidingTech(int[] arr, int k) {
        int n = arr.length;
        int i = 0;
        int j = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        while (j < n) {
            sum = sum + arr[j];
            if (j - i + 1 < k) {
                j++;
            } else if (j - i + 1 == k) {
                max = Math.max(max, sum);
                sum = sum - arr[i];
                i++;
                j++;
            }
        }
        System.out.println(max);
    }

    private static void naiveApproach(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i];
            for (int j = 0; j < k; j++) {
                sum = sum + arr[j];
                max = Math.max(sum, max);
            }
        }
        System.out.println(max);
    }
}
