package Rotation;

/**
 * AllRowOfMatrixEachOtherRotation 
 */
public class AllRowOfMatrixEachOtherRotation {

    public static void main(String[] args) {
        int n = 4;
        int mat[][] = { { 1, 2, 3, 4 }, { 4, 1, 2, 3 }, { 3, 4, 1, 2 }, { 2, 3, 4, 1 } };
        if (isPermutedMatrix(mat, n)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    private static boolean isPermutedMatrix(int[][] mat, int n) {
        String str_cat = "";
        for (int i = 0; i < n; i++) {
            str_cat = str_cat + "-" + mat[0][i];
        }
        str_cat = str_cat + str_cat;

        for (int i = 1; i < n; i++) {
            String currString = "";
            for (int j = 1; j < n; j++) {
                currString = currString + "-" + mat[i][j];
            }
            if (!str_cat.contains(currString)) {
                return false;
            }

        }
        return true;
    }
}