package Rearrangement;

import java.util.Arrays;

/**
 * EvenGreaterThanOdd Rearrange array such that even positioned are greater than
 * odd
 */
public class EvenGreaterThanOdd {

    public static void main(String[] args) {
        int A[] = { 1, 3, 2, 2, 5 };
        int n = A.length;
        assign(A, n);
    }

    private static void assign(int [] A, int n) {
        Arrays.sort(A);
        int ans[] = new int[n];
        int p = 0, q = n - 1;
        for(int i = 0; i < n; i++) {
            if((i+1) % 2 == 0) {
                ans[i] = A[q--];
            }
            else {
                ans[i] = A[p++];
            }
        }
        for (int i = 0; i < n; i++) 
            System.out.print(ans[i] + " ");
    }
}