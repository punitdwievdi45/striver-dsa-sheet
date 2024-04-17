package recurssion;

public class ReversePrinter {
    public static void main(String[] args) {
        int arr[] = {2,3,4,5,6};
        System.out.println("Before Reverse");
        for (int i : arr){
            System.out.print(i+", ");
        }
        printRecurssion(arr,0,arr.length-1);
        System.out.println();
        System.out.println("After Reverse");
        for (int i : arr){
            System.out.print(i+", ");
        }
    }

    private static void printRecurssion(int[] arr, int left, int right) {
        if (left >= right){
            return;
        }
        swapArray(arr,left,right);
        printRecurssion(arr,left+1, right-1);
    }

    private static void swapArray(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
    }
}
