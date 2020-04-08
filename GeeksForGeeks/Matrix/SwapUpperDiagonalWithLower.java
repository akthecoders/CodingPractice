/**
 * SwapUpperDiagonalWithLower
 */
public class SwapUpperDiagonalWithLower {

    public static void main(String[] args) {
        int arr[][] = { { 2, 3, 5, 6 }, 
                        { 4, 5, 7, 9 }, 
                        { 8, 6, 4, 9 }, 
                        { 1, 3, 5, 6 } }; 
  
        // Function call 
        swapUpperToLower(arr);
    }

    public static void swapUpperToLower(int[][] arr) {
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            for(int j = i + 1; j < n; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }


        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}