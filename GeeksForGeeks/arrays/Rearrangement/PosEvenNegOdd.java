package Rearrangement;

/**
 * PosEvenNegOdd
 */
public class PosEvenNegOdd {

    public static void main(String[] args) {
        int[] arr = { 1, -3, 5, 6, -3, 6, 7, -4, 9, 10 }; 
        int n = arr.length;  
        printArray(arr, n); 
        modify(arr, n);
        printArray(arr, n); 
    }

    public static void modify(int[] arr, int n) {
        for(int i = 0; i < n; i++) {
            if((arr[i] >= 0) && i % 2 == 1) {
                for(int j = i + 1; j < n; j++) {
                    if(arr[j] < 0 && j%2 == 0) {
                        swap(arr, i, j);  
                        break ; 
                    }
                }
            }
            else if((arr[i] < 0) && i % 2 == 0) {
                for(int j = i + 1; j < n; j++) {
                    if(arr[j] >= 0 && j%2 == 1) {
                        swap(arr, i, j);  
                        break ; 
                    }
                }
            }
        }
    }

    public static void swap(int[] a, int i, int j) 
    { 
        int temp = a[i];  
        a[i] = a[j];  
        a[j] = temp;  
    } 
  
    public static void printArray(int[] a, int n) 
    { 
        for (int i = 0; i < n; i++) 
            System.out.print(a[i] + " "); 
        System.out.println(); 
    }  
}