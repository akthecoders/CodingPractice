package Rearrangement;

/**
 * SortArryAccToA2
 */
public class SortArryAccToA2 {

    public static void main(String[] args) {
        int A1[] = { 2, 1, 2, 5, 7, 1, 9, 3, 6, 8, 8 }; 
        int A2[] = { 2, 1, 8, 3 }; 
        int m = A1.length; 
        int n = A2.length; 
        System.out.println("Sorted array is "); 
        sortAccording(A1, A2, m, n); 
        
        for (int i : A1) {
            System.out.print(i + " ");
        }
    }

    private static void sortAccording(int[] A1, int[] A2, int m, int n) {
        int[] tAry1 = new int[m];
        int count = 0;
        for(int i = 0; i < n; i++) {
            int numToGet = A2[i];
            for(int j = 0; j < m; j++) {
                if(numToGet == A1[j]) {
                    tAry1[count++] = numToGet;
                    A1[j] = -1;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            if(A1[i] != -1) {
                tAry1[count++] = A1[i];
            }
        }

        for(int i = 0; i < m; i++) {
            A1[i] = tAry1[i];
        }
    }

    
}