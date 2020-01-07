package Rearrangement;

/**
 * GenerateAllPossibleSortedArray
 */
public class GenerateAllPossibleSortedArray {

    public static void main(String[] args) {
        int A[] = {10, 15, 25}; 
        int B[] = {5, 20, 30}; 
        int n = A.length; 
        int m = B.length; 
        generate(A, B, n, m);
    }

    public static void generate(int[] A, int[] B, int n, int m) {
        int C[] = new int[m+n];
        generateUtil(A, B, C, 0, 0, m, n, 0 , true);
    }

    public static void generateUtil(int A[], int B[], int C[], int i, int j, int m, int n, int len, boolean flag) {
        if(flag) {
            if(len != 0) {
                printArr(C, len);
            }
            for(int k = i; k < m; k++) {
                if(len == 0) {
                    C[len] = A[k];
                    generateUtil(A, B, C, k + 1, j, m, n, len, !flag);
                }
                else {
                    if(A[k] > C[len]) {
                        C[len+1] = A[k];
                        generateUtil(A, B, C, k + 1, j, m, n, len + 1, !flag);
                    }
                }
            }
        }
        else {
            for(int l = j; l < n; l++) {
                if(B[l] > C[len]) {
                    C[len + 1] = B[l];
                    generateUtil(A, B, C, i, l + 1, m, n, len + 1, !flag);
                }
            }
        }
    }

    public static void printArr(int arr[], int n)  
    { 
        for (int i = 0; i < n; i++) 
            System.out.print(arr[i] + " "); 
        System.out.println(""); 
    } 
}