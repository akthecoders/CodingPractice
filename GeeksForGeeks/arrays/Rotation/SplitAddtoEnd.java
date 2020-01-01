package Rotation;

/**
 * SplitAddtoEnd
 */
public class SplitAddtoEnd {

    public static void main(String[] args) {
        int arr[] = { 12, 10, 5, 6, 52, 36 }; 
        int n = arr.length; 
        int position = 2;
        splitArry(arr, n, position); 
  
        for (int i = 0; i < n; ++i) 
            System.out.print(arr[i] + " "); 
    }

    private static void splitArry(int[] arr, int n, int k) {
        int[] tmp = new int[n*2]; 
        System.arraycopy(arr, 0, tmp, 0, n); 
        System.arraycopy(arr, 0, tmp, n, n);
        for(int i = k; i < n + k; i++) {
            arr[i - k] = tmp[i];
        }
    }
}