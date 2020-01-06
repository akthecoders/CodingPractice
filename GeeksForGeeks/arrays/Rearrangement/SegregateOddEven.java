package Rearrangement;

import java.util.Arrays;

/**
 * SegregateOddEven
 */
public class SegregateOddEven {

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 4, 7, 6, 9, 10 };
        int n = arr.length;
        System.out.println(Arrays.toString(arr)); 
        arrayEvenAndOdd(arr, n);
        System.out.println(Arrays.toString(arr)); 
    }

    public static void arrayEvenAndOdd(int[] arr, int n) {
        int i = -1, j = 0;
        while(j != n) {
            if(arr[j] % 2 == 0) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            j++;
        }
    }

}