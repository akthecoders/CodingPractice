package Rearrangement;

/**
 * ArrayMaxMinv2 with O(1) space
 */
public class ArrayMaxMinv2 {

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int n = arr.length;

        System.out.println("Original Array");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");

        rearrange(arr, n);

        System.out.print("\nModified Array\n");
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }

    private static void rearrange(int arr[], int n) {
        for(int i = 0; i < n ; i = i + 2) {
            if((i + 1) % 2 == 1) {
                rightShift(arr, i, n - 1);
            }
        }
    }

    private static void rightShift(int[] arr, int start, int end) {
        int temp = arr[end];
        for(int i = end; i > start; i--) {
            arr[i] = arr[i - 1];
        }
        arr[start] = temp;
    }
}