// Lucky Numbers in a Matrix
import java.util.*;
public class P1380 {
    public List<Integer> luckyNumbers(int[][] matrix) {
        int[] minRow = new int[matrix.length];
        int[] maxCol = new int[matrix[0].length];
        Arrays.fill(minRow, Integer.MAX_VALUE);
        for (int i = 0; i < minRow.length; i++) {
            for (int j = 0; j < maxCol.length; j++) {
                minRow[i] = Math.min(minRow[i], matrix[i][j]);
                maxCol[j] = Math.max(maxCol[j], matrix[i][j]);
            }
        }

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < minRow.length; i++) {
            for (int j = 0; j < maxCol.length; j++) {
                if (minRow[i] == maxCol[j]) {
                    list.add(minRow[i]);
                }
            }
        }
        return list;
    }
}