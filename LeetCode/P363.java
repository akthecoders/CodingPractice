import java.util.TreeSet;

// Max Sum of Rectangle No Larger Than K
public class P363 {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int sumColumn[] = new int[matrix[0].length];
        int max = Integer.MIN_VALUE;
        for (int l = 0; l < matrix.length; l++) {
            sumColumn = new int[matrix[0].length];
            for (int r = l; r < matrix.length; r++) {
                for (int i = 0; i < matrix[0].length; i++) {
                    sumColumn[i] += matrix[r][i];
                }
                max = Math.max(max, kadanes(sumColumn, k));
                if (max == k) {
                    return k;
                }
            }
        }
        return max;
    }

    public int kadanes(int[] arr, int k) {
        int max = Integer.MIN_VALUE;
        int curr = 0;
        TreeSet<Integer> set = new TreeSet<>();
        set.add(0);
        for (int i = 0; i < arr.length; i++) {
            curr += arr[i];
            Integer ceil = set.ceiling(curr - k);
            if (ceil != null) {
                max = Math.max(max, curr - ceil);
            }
            set.add(curr);
        }
        return max;
    }
}