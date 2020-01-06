package Rearrangement;

import java.util.Arrays;
import java.util.Random;

/**
 * ShuffleArray
 */
public class ShuffleArray {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8}; 
         int n = arr.length; 
         System.out.println(Arrays.toString(arr)); 
         randomize (arr, n); 
         System.out.println(Arrays.toString(arr)); 
    }

    public static void randomize(int[] arr, int n) {
        Random r = new Random();
        for(int i = n - 1; i > 0; i--) {
            int j = r.nextInt(i+1);
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }
}