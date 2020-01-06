package Rearrangement;

/**
 * LargestSubArrayequal01v1
 */
public class LargestSubArrayequal01v1 {

    public static void main(String[] args) {
        int arr[] = {1, 0, 0, 1, 0, 1, 1}; 
        int size = arr.length; 
  
        findSubArray(arr, size); 
    }

    public static void findSubArray(int arr[], int n) {
        int sum = 0;
        int maxSize = -1, startIndex = 0;
        int endIndex = 0;

        for(int i = 0; i < n; i++) {
            sum = (arr[i] == 0) ? -1 : 1;
            for( int j = i + 1; j < n; j++) {
                if(arr[j] == 0)
                    sum += -1;
                else 
                    sum += 1;

                if(sum == 0 && maxSize < j - i + 1) {
                    maxSize = j - i + 1;
                    startIndex = i;
                }
            }
        }
        endIndex = startIndex + maxSize - 1;
        if(maxSize == -1) {
            System.out.println("No such subarray");
        }
        else
            System.out.println(startIndex + " to " + endIndex);
    }
}