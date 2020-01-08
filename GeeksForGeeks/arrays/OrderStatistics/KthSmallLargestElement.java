package OrderStatistics;

import java.util.Arrays;

/**
 * KthSmallLargestElement
 */
public class KthSmallLargestElement {

    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15};
        int k = 3;
        for (int i : arr) {
            System.out.print(i + " ");   
        }
        System.out.println();
        kthSmallestElement(arr, k);
        kthLargestElement(arr, k);
    }

    public static void kthSmallestElement(int[] arr, int k) {
        Arrays.sort(arr);
        System.out.println("kth Smallest :" + arr[k-1]);
    }

    public static void kthLargestElement(int[] arr, int k) {
        Arrays.sort(arr);
        System.out.println("kth Largest : " + arr[arr.length - k]);
    }
}