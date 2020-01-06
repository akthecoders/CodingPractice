package Rearrangement;

/**
 * PosNeg Rearrange positive and negative numbers in O(n) time and O(1) extra
 * space An array contains both positive and negative numbers in random order.
 * Rearrange the array elements so that positive and negative numbers are placed
 * alternatively. Number of positive and negative numbers need not be equal. If
 * there are more positive numbers they appear at the end of the array. If there
 * are more negative numbers, they too appear in the end of the array. For
 * example, if the input array is [-1, 2, -3, 4, 5, 6, -7, 8, 9], then the
 * output should be [9, -7, 8, -3, 5, -1, 2, 4, 6]
 */
public class PosNeg {

    public static void main(String[] args) {
        int arr[] = { -1, 2, -3, 4, 5, 6, -7, 8, 9 };
        int n = arr.length;
        rearrange(arr, n);
        System.out.println("Array after rearranging: ");
        printArray(arr, n);
    }

    public static void rearrange(int[] arr, int n) {
        int i  = -1, j = 0, temp = 0;
        for(j = 0; j < n; j++) {
            if(arr[j] < 0) {
                i++;
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int pos = i + 1;
        int neg = 0;
        while(pos < n && neg < pos && arr[neg] < 0) {
            temp = arr[neg];
            arr[neg] = arr[pos];
            arr[pos] = temp;
            pos++;
            neg = neg + 2;
        }
    }

    public static void printArray(int arr[], int n) {
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + "   ");
    }
}