package Sorting;

/**
 * MinSwapsRequired
 */
public class MinSwapsRequired {

    public static void main(String[] args) {
        int ar[] = { 0, 0, 1, 0, 1, 0, 1, 1 }; 
        System.out.println(findMinSwaps(ar, ar.length)); 
    }

    public static int findMinSwaps(int[] arr, int n) {
        int noOfZeros[] = new int[n];
        int i, count = 0;
        noOfZeros[n-1] = 1 - arr[n-1];
        for(i = n - 2; i >= 0; i--){
            noOfZeros[i] = noOfZeros[i+1];
            if(arr[i] == 0) {
                noOfZeros[i]++;
            }
        }

        for(i = 0; i < n; i++) {
            if(arr[i] == 1) {
                count += noOfZeros[i];
            }
        }
        return count;
    }
}