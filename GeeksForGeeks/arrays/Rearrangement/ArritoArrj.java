package Rearrangement;

/**
 * ArritoArrj Given an array of size n where all elements are distinct and in
 * range from 0 to n-1, change contents of arr[] so that arr[i] = j is changed
 * to arr[j] = i.
 */
public class ArritoArrj {
    public static void main(String[] args) {
        int arr[] = { 2, 0, 1, 4, 5, 3 };
        int n = arr.length;

        System.out.println("Given array is : ");
        printArray(arr, n);

        rearrange(arr, n);

        System.out.println("Modified array is :");
        printArray(arr, n);
    }

    public static void rearrange(int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            arr[arr[i]  % n] += i * n;
        }
        for(int i = 0; i < n; i++) {
            arr[i] /= n;
        }
    }

    public static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }

        System.out.println();
    }
}