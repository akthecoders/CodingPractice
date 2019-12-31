package Rotation;

/**
 * MaxHammingDistance
 */
public class MaxHammingDistance {

    public static void main(String args[]) {
        int arr[] = {2, 4, 6, 8};  
        int n = arr.length; 
        System.out.print(maxHamming(arr, n));
    }

    private static int maxHamming(int[] arr, int n) {
        int maxHamming = 0;
        int copyArr[] = new int[n * 2];
        for(int i = 0; i < n; i++ ){
            copyArr[i] = arr[i];
        }
        for(int i = 0; i < n; i++ ){
            copyArr[i + n] = arr[i];
        }
        int tempCount = 0;
        for(int i = 1; i < n; i++) {
            tempCount = 0;
            for(int j = i, k = 0; j < n + i; j++, k++) {
                if(arr[k] != copyArr[j]) {
                    tempCount++;
                }
            }
            if(tempCount > maxHamming) {
                maxHamming = tempCount;
            }
        }
        return maxHamming;
    }

}