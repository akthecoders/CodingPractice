import java.util.HashMap;
import java.util.Map;

//Flip Columns For Maximum Number of Equal Rows
public class P1072 {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        HashMap<String, Integer> h = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            String key1 = "";
            String key2 = "";
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1) {
                    key1 = key1 + "0" + "|";
                    key2 = key2 + "1" + "|";
                } else {
                    key1 = key1 + "1" + "|";
                    key2 = key2 + "0" + "|";
                }
            }
            if (h.containsKey(key1)) {
                h.put(key1, h.get(key1) + 1);
            } else {
                h.put(key1, 1);
            }
            if (h.containsKey(key2)) {
                h.put(key2, h.get(key2) + 1);
            } else {
                h.put(key2, 1);
            }
        }
        int max = 0;
        for (Map.Entry<String, Integer> e : h.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
            }
        }
        return max;
    }
}