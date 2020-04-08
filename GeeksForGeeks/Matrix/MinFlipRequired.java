/**
 * MinFlipRequired
 */
public class MinFlipRequired {

    public static void main(String[] args) {
        int n = 3;
        int mat[][] = { { 0, 0, 1 }, { 1, 1, 1 }, { 1, 0, 0 } };

        System.out.println(minimumflip(mat, n));
    }

    public static int minimumflip(int[][] mat, int n) {
        int count = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(mat[i][j] != mat[j][i]) {
                    count++;
                }
            }
        }
        return count;
    }
}