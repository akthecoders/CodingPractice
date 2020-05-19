import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Sort the Matrix Diagonally
public class P1329 {
    public int[][] diagonalSort(int[][] mat) {
        List<Integer> valrow = new ArrayList<>();
        List<Integer> valcol = new ArrayList<>();

        for (int k = 0; k < mat[0].length; k++) {

            for (int i = 0; i < mat.length; i++) {
                if ((k + i) < mat[0].length) {
                    valrow.add(mat[i][k + i]);
                }
                if ((k + i) < mat.length && k >= 1) {
                    valcol.add(mat[k + i][i]);
                }
            }

            Collections.sort(valrow);
            Collections.sort(valcol);

            for (int i = 0; i < mat.length; i++) {
                if ((k + i) < mat[0].length) {
                    mat[i][k + i] = valrow.get(i);
                }
                if ((k + i) < mat.length && k >= 1) {
                    mat[k + i][i] = valcol.get(i);
                }
            }
            valrow.clear();
            valcol.clear();
        }
        return mat;
    }
}