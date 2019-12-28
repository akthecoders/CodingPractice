package Rotation;

import java.util.Scanner;

/**
 * SortPossibleAfterShuffle Given an array of size N, the task is to determine
 * whether its possible to sort the array or not by just one shuffle. In one
 * shuffle, we can shift some contiguous elements from the end of the array and
 * place it in the front of the array.
 */
public class SortPossibleAfterShuffle {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int noOfElements = scan.nextInt();
        int[] intAry = new int[noOfElements];
        for(int i = 0; i < noOfElements; i++) {
            intAry[i] = scan.nextInt();
        }
        System.out.println(isPossibleToSort(intAry, noOfElements));
        scan.close();
    }

    private static String isPossibleToSort(int[] number, int noOfElements) {
        if(is_sorted(number, noOfElements)) {
            return "Yes";
        }
        if(noOfElements == 1) {
            return "Yes";
        }
        int i = 0, j = 0;
        for (i = 0; i < noOfElements - 1; i++) {  
            if (number[i] > number[i + 1]) {  
                break;  
            }  
        }  
        i++;  
        boolean flag = true;
        for(j = i; j < noOfElements - 1; j++) {
            if(number[j] > number[j + 1]) {
                flag = false;
                break;
            }
        }

        if(!flag) {
            return "No";
        }
        else {
            if(number[noOfElements - 1] <= number[0]) {
                return "Yes";
            }
            else 
                return "No";
        }
    }

    private static boolean is_sorted(int a[], int n) {
        int c1 = 0, c2 = 0;
        // if array is ascending
        for (int i = 0; i < n - 1; i++) {
            if (a[i] <= a[i + 1])
                c1++;
        }

        // if array is descending
        for (int i = 1; i < n; i++) {
            if (a[i] <= a[i - 1])
                c2++;
        }
        if (c1 == n -1 || c2 == n - 1)
            return true;

        return false;
    }
}