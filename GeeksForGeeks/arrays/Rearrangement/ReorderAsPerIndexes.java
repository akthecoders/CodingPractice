package Rearrangement;

/**
 * ReorderAsPerIndexes Given two integer arrays of same size, “arr[]” and
 * “index[]”, reorder elements in “arr[]” according to given index array. It is
 * not allowed to given array arr’s length.
 */
public class ReorderAsPerIndexes {

    public static void main(String[] args) {
        int arr[] = { 50, 40, 70, 60, 90 };
        int index[] = { 3, 0, 4, 1, 2 };
        reorder(arr, index);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        for (int i : index) {
            System.out.print(i + " ");
        }
    }

    public static void reorder(int[] arr, int[] index) {
        for(int i = 0; i < arr.length; i++) {
            while(index[i] != i) {
                int tArr = arr[index[i]];
                int tIndex = index[index[i]];

                arr[index[i]] = arr[i];
                index[index[i]] = index[i];
                
                arr[i] = tArr;
                index[i] = tIndex;
            }
        }
    }
}