package Rearrangement;

/**
 * MaxSubArrauProduct
 */
public class MaxSubArrauProduct {

    public static void main(String[] args) {
        int arr[] = { 1, -2, -3, 0, 7, -8, -2 }; 
        System.out.println("Maximum Sub array product is "
                           + maxSubarrayProduct(arr)); 
    }

    public static int min(int x, int y) { return x < y ? x : y; } 
    public static int max(int x, int y) { return x > y ? x : y; } 

    public static int maxSubarrayProduct(int[] arr) {
        int maxSoFar = 1;
        int maxEndHere = 1;
        int n = arr.length;
        int minEndHere = 1;
        int flag = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] > 0) {
                maxEndHere = maxEndHere * arr[i];
                minEndHere = min(minEndHere * arr[i], 1);
                flag = 1;
            }
            else if(arr[i] == 0) {
                maxEndHere = 1;
                minEndHere = 1;
            }
            else {
                int temp = maxEndHere;
                maxEndHere = max(minEndHere * arr[i], 1);
                minEndHere = temp * arr[i];
            }

            if (maxSoFar < maxEndHere) 
                maxSoFar = maxEndHere; 
        }

        if(flag == 0 && maxSoFar == 1) {
            return 0;
        }
        else {
            return maxSoFar;
        }
    } 
}