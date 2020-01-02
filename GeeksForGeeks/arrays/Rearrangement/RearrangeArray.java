package Rearrangement;

/**
 * RearrangeArray
 * Given an array of elements of length N, ranging from 0 to N – 1. All elements may not be present in the array. If element is not present then there will be -1 present in the array. Rearrange the array such that A[i] = i and if i is not present, display -1 at that place.
 */
public class RearrangeArray {

    public static void main(String[] args) {
        int arr[] = {-1, -1, 6, 1, 9, 3, 2, -1, 4, -1};
        arr = rearrange(arr);
        printArray(arr);
    }

    private static int[] rearrange(int arr[]) {
        int[] tArr = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            tArr[i] = -1;
        }

        for(int i = 0; i < arr.length; i++){
            if(arr[i] != -1) {
                tArr[arr[i]] = arr[i];
            }
        }
        return tArr;
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}