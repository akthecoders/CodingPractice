/**
 * Rotate90DegreeWithTranspose
 */
public class Rotate90DegreeWithTranspose {

    public static void main(String[] args) {
        int arr[][] = { { 1, 2, 3, 4 }, 
                        { 5, 6, 7, 8 }, 
                        { 9, 10, 11, 12 }, 
                        { 13, 14, 15, 16 } }; 
  
        rotate90(arr); 
        printMatrix(arr); 
    }

    public static void rotate90(int[][] arr) {
        int R = arr.length;
        int C = arr[0].length;

        transpose(arr, R, C);
        reverseColumns(arr);
    }

    public static void transpose(int[][] arr, int R, int C) {
        for(int i = 0; i < R; i++) {
            for(int j = i; j < C; j++) {
                int temp = arr[j][i]; 
                arr[j][i] = arr[i][j]; 
                arr[i][j] = temp; 
            }
        }
    }

    static void reverseColumns(int arr[][]) { 
        for (int i = 0; i < arr[0].length; i++) 
            for (int j = 0, k = arr[0].length - 1; j < k; j++, k--) { 
                int temp = arr[j][i]; 
                arr[j][i] = arr[k][i]; 
                arr[k][i] = temp; 
            } 
    }

    static void printMatrix(int arr[][]) { 
        for (int i = 0; i < arr.length; i++) { 
            for (int j = 0; j < arr[0].length; j++) 
                System.out.print(arr[i][j] + " "); 
            System.out.println(""); 
        } 
    } 
}