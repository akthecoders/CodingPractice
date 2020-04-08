/**
 * PrintMatrixZigZag
 */
public class PrintMatrixZigZag {
    static final int ROW = 5; 
    static final int COL = 4;
    public static void main(String[] args) {
        int M[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 }, { 17, 18, 19, 20 }, };
        System.out.print("Given matrix is \n");
        printMatrix(M);

        System.out.print("\nDiagonal printing of matrix is \n");
        diagonalOrder(M);
    }

    public static void diagonalOrder(int[][] M) {
        System.out.println(M[0][0]);
        for(int i = 1; i < ROW; i++) {
            for(int j = i, k = 0; j >= 0 && k < COL; j--, k++) {
                System.out.print(M[j][k]);
            }
            System.out.println();
        }
    }

    static void printMatrix(int matrix[][]) {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++)
                System.out.print(matrix[i][j] + " ");
            System.out.print("\n");
        }
    }
}