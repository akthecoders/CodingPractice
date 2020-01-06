package Rearrangement;

/**
 * AllZerosToEndV2
 */
public class AllZerosToEndV2 {

    public static void main(String[] args) {
        int arr[] = { 0, 1, 9, 8, 4, 0, 0, 2, 7, 0, 6, 0, 9 };
        int n = arr.length;

        System.out.print("Original array: ");
        printArray(arr, n);

        moveZerosToEnd(arr, n);

        System.out.print("\nModified array: ");
        printArray(arr, n);
    }

    private static void moveZerosToEnd(int[] arr, int n) {
        int count = 0;
        for(int i = 0; i < n; i++) {
            if(arr[i] != 0) {
                if(i > count) {
                    int temp = arr[i];
                    arr[i] = arr[count];
                    arr[count] = temp;
                    count++;
                } 
                else {
                    count++;
                }
            }
        }
    }

    public static void printArray(int arr[], int n) {
        for (int i : arr) {
            System.out.print(i + " ");   
        }
    }
}