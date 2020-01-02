package Rearrangement;

/**
 * ReverseAnArray
 */
public class ReverseAnArray {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6}; 
        printArray(arr, 6); 
        reverseArray(arr, 0, 5); 
        System.out.print("Reversed array is \n"); 
        printArray(arr, 6);  
    }

    private static void reverseArray(int[] arr, int start, int end) {
        if(start >= end) {
            return;
        }
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        reverseArray(arr, start + 1, end - 1);
    }

    private static void printArray(int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}