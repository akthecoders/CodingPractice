package Rearrangement;

/**
 * Shuffle2nWithouExtraSpace
 */
public class Shuffle2nWithouExtraSpace {

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 2, 4, 6}; 
        rearrange(arr); 
        for (int i = 0; i < arr.length; i++) 
        System.out.print(" " + arr[i]); 
    }

    public static void rearrange(int[] arr) {
        if(arr == null || arr.length % 2 == 1) return;
        
        int currIdx = (arr.length - 1) / 2;

        while(currIdx > 0) {
            int count = currIdx, swapIdx = currIdx;

            while(count-- > 0) {
                int temp = arr[swapIdx + 1];
                arr[swapIdx + 1] = arr[swapIdx];
                arr[swapIdx] = temp;
                swapIdx++;
            }
            currIdx--;
        }
    }
}