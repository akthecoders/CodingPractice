package Rotation;

/**
 * RestoreSortedArray
 */
public class RestoreSortedArray {

    public static void main(String args[]) {
        int arr[] = {1, 2, 3, 4, 5}; 
        int n = arr.length; 
        restoreSortedArray(arr, n); 
        printArray(arr, n); 
    }

    private static void restoreSortedArray(int[] arr, int n) {
        int splitIndex = 0;
        for(int i = 0; i < n - 1;i++) {
            if(arr[i] >= arr[i + 1]) {
                splitIndex = i + 1;
                break;
            }
        }
        if(splitIndex > 0) {
            reverse(arr, 0, splitIndex - 1);
            reverse(arr, splitIndex, n - 1);
            reverse(arr, 0 , n - 1);
        }
    }
    
    private static void reverse(int[] input, int start, int end) {
        while(end > start) {
            int temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
    }

    private static void printArray(int arr[], int size)  
    { 
        for (int i = 0; i < size; i++)  
        { 
            System.out.print(arr[i] + " "); 
        } 
    } 
}