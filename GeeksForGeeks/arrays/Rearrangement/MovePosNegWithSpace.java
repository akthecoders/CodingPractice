package Rearrangement;

/**
 * MovePosNegWithSpace Given an unsorted array of both negative and positive
 * integer. The task is place all negative element at the end of array without
 * changing the order of positive element and negative element.
 */
public class MovePosNegWithSpace {

    public static void main(String[] args) {
        int arr[] = { 1, -1, -3, -2, 7, 5, 11, 6 };
        int n = arr.length;

        segregateElements(arr, n);

        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    public static void segregateElements(int[] arr, int n) {
        int tArr[] = new int[n];
        int index = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] >= 0) {
                tArr[index++] = arr[i];
            }
        }
        if (index == n || index == 0) 
            return; 
        for(int i = 0; i < n; i++) {
            if(arr[i] < 0) {
                tArr[index++] = arr[i];
            }
        }

        for (int i = 0; i < n; i++) 
            arr[i] = tArr[i]; 
    } 
}