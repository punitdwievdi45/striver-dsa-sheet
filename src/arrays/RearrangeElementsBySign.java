package arrays;

import java.util.ArrayList;

public class RearrangeElementsBySign {
    public static void main(String[] args) {
        // Original array
        int arr[] = {3, 1, -2, -5, 2, -4, 8, 9};

        // Choose the appropriate function based on your needs:
        // - rearrangeBasedOnsign: Works only when positive and negative numbers are equal in count (commented out)
        // - bruteForceRearrangeBasedOnsign: Works for any number of positive and negative numbers



        // Using brute force approach to rearrange elements based on their sign
        bruteForceRearrangeBasedOnsign(arr); // This solution supports even when the number of positive and negative integers is not equal
    }

    // Method to rearrange elements based on their sign using brute force approach
    private static void bruteForceRearrangeBasedOnsign(int[] arr) {
        // Initialize a new array to store rearranged elements
        int arr1[] = new int[arr.length];
        // ArrayLists to store positive and negative integers separately
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();

        // Loop through the original array to separate positive and negative integers
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                neg.add(arr[i]); // Add negative integers to the 'neg' ArrayList
            } else {
                pos.add(arr[i]); // Add positive integers to the 'pos' ArrayList
            }
        }

        // Rearrange elements in the new array based on the size of positive and negative ArrayLists
        if (pos.size() > neg.size()) {
            for (int i = 0; i < neg.size(); i++) {
                arr1[2 * i] = pos.get(i); // Place positive integer at even indices
                arr1[2 * i + 1] = neg.get(i); // Place negative integer at odd indices
            }
            // Add remaining positive integers to the end of the new array
            int index = neg.size() * 2;
            for (int i = neg.size(); i < pos.size(); i++) {
                arr1[index] = pos.get(i);
                index++;
            }
        } else {
            for (int i = 0; i < pos.size(); i++) {
                arr1[2 * i] = pos.get(i); // Place positive integer at even indices
                arr1[2 * i + 1] = neg.get(i); // Place negative integer at odd indices
            }
            // Add remaining negative integers to the end of the new array
            int index = pos.size() * 2;
            for (int i = pos.size(); i < neg.size(); i++) {
                arr1[index] = neg.get(i);
                index++;
            }
        }

        // Print the rearranged array
        for (int i : arr1) {
            System.out.println(i);
        }
    }

    // Method to rearrange elements based on their sign (Only works when the count of positive and negative integers is equal)
    private static void rearrangeBasedOnsign(int[] arr) {
        // Initialize a new array to store rearranged elements
        int arr1[] = new int[arr.length];
        int posIndex = 0;
        int negativeIndex = 1;

        // Loop through the original array to rearrange elements based on their sign
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                arr1[negativeIndex] = arr[i]; // Place negative integer at odd indices
                negativeIndex += 2;
            } else {
                arr1[posIndex] = arr[i]; // Place positive integer at even indices
                posIndex += 2;
            }
        }

        // Print the rearranged array
        for (int i : arr1) {
            System.out.println(i);
        }
    }
}
