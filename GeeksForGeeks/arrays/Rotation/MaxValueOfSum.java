package Rotation;

/**
 * MaxValueOfSum
 */
public class MaxValueOfSum {

    public static void main(String[] args) {
        int arr[] = new int[]{10, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        System.out.println("Max sum is " + maxSum(arr)); 
    }

    private static int maxSum(int[] arr) {
        int arrSum = 0;
        int currVal = 0;
        for(int i = 0; i < arr.length; i++) {
            arrSum += arr[i];
            currVal = currVal + (i * arr[i]);
        }
        int maxVal = currVal;
        for(int i = 1; i < arr.length; i++) {
            currVal = currVal + arrSum - arr.length*arr[arr.length - i];
            if(currVal > maxVal) {
                maxVal = currVal;
            }
        }
        return maxVal;
     }
}