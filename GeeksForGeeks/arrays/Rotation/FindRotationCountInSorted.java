package Rotation;

/**
 * FindRotationCountInSorted
 */
public class FindRotationCountInSorted {

    public static void main(String[] args) {
        int arr[] = {15, 18, 2, 3, 6, 12}; 
        int n = arr.length; 
      
        System.out.println(countRotations(arr, n)); 
    }

    private static int countRotations(int[] arr, int n) {
        int i = 0;
        for(i = 0; i < n - 1; i++) {
            if(arr[i] > arr[i+1]) {
                break;
            }
        }
        return i + 1;
    }
}