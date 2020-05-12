import java.util.HashMap;
import java.util.Map;

//Number of Submatrices That Sum to Target
public class P1074 {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        if (matrix == null)
            return 0;
        int rowLen = matrix.length;
        int colLen = matrix[0].length;
        int ans = 0;

        for (int left = 0; left < colLen; left++) {
            int tempArr[] = new int[rowLen];
            for (int right = left; right < colLen; right++) {
                for (int row = 0; row < rowLen; row++) {
                    tempArr[row] = tempArr[row] + matrix[row][right];
                }
                ans += sumFinder(tempArr, target);
            }
        }
        return ans;
    }

    public int sumFinder(int arr[], int target) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int ans = 0;
        int currSum = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum += arr[i];
            int required = currSum - target;
            if (map.containsKey(required)) {
                ans += map.get(required);
            }

            map.put(currSum, map.get(currSum) != null ? map.get(currSum) + 1 : 1);
        }
        return ans;
    }
}