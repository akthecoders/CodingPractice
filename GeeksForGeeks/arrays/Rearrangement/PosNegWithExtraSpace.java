package Rearrangement;

/**
 * PosNegWithExtraSpace
 */
public class PosNegWithExtraSpace {

    public static void main(String[] args) {
        int arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}; 
        int n = arr.length; 
  
        System.out.println("Given array is "); 
        printArray(arr, n); 
  
        rearrange(arr, n); 
  
        System.out.println("RearrangeD array is "); 
        printArray(arr, n); 
    }

    public static void rearrange(int[] arr, int n) {

        int outOfPlace = -1;
        for(int i = 0 ; i < n; i++) {
            if(outOfPlace >= 0) {
                if(((arr[i] >= 0) && (arr[outOfPlace] < 0)) || ((arr[i] < 0) && arr[outOfPlace] >= 0)) {
                    rightRotate(arr, n, outOfPlace, i);
                    if(i - outOfPlace > 2) {
                        outOfPlace = outOfPlace + 2;
                    }
                    else 
                        outOfPlace = -1;
                 }
            }
        if(outOfPlace == -1) {
            if(((arr[i] >= 0) && ((i % 2) == 0)) || ((arr[i] < 0) && (arr[i] %2 == 1))) {
                outOfPlace = i;
            }
        }
        }
    }

    public static void rightRotate(int arr[], int n, int outofplace, int cur)  
    { 
        int tmp = arr[cur]; 
        for (int i = cur; i > outofplace; i--) 
            arr[i] = arr[i - 1]; 
        arr[outofplace] = tmp; 
    } 

    public static void printArray(int arr[], int n)  
    { 
        for (int i = 0; i < n; i++) 
            System.out.print(arr[i] + " "); 
        System.out.println(""); 
    } 
}