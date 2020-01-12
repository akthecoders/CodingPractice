package OrderStatistics;

/**
 * SlidingWindowMaximum
 */
public class SlidingWindowMaximum {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        printMaxOfAllSubArrayOfSizeK(arr, k);   
    }

    public static void printMaxOfAllSubArrayOfSizeK(int[] arr, int k) {
        for(int i = 0; i < arr.length - k; i++) {
            System.out.print(max(arr, i, i + k) + " ");
        }
    }

    public static int max(int[] arr, int start, int end ) {
        int max = 0;
        if(end > arr.length) {
            for(int i = start; i < arr.length; i++) {
                if(arr[i] > max) {
                    max = arr[i];
                }
            }
        }
        else {
            for(int i = start; i <= end; i++) {
                if(arr[i] > max) {
                    max = arr[i];
                }
            }
        }
        return max;
    }
}