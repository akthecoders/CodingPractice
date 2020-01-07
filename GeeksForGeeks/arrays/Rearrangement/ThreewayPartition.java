package Rearrangement;

/**
 * ThreewayPartition
 */
public class ThreewayPartition {

    public static void main(String[] args) {
        int arr[] = {1, 14, 5, 20, 4, 2, 54, 20, 87, 98, 3, 1, 32};  
        int lowVal = 14, highVal = 20;

        rearrange(arr, lowVal, highVal);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    public static void rearrange(int[] arr, int lowVal, int highVal) {
        int start = 0;
        int end = arr.length - 1;
        for(int i = 0; i <= end; i++) {
            if(arr[i] < lowVal) {
                int temp = arr[i];
                arr[i] = arr[start];
                arr[start] = temp;
                i++;
                start++;
            }
            else if(arr[i] > highVal) {
                int temp = arr[i];
                arr[i] = arr[end];
                arr[end] = temp;
                i++;
                end--;
            }
            else {
                i++;
            }
        }
    }
}