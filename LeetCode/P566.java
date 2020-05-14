//Reshape the Matrix
public class P566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        if (nums.length * nums[0].length != r * c)
            return nums;

        int result[][] = new int[r][c];
        int rI = 0;
        int cI = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                result[rI % r][cI % c] = nums[i][j];
                cI++;
                if (cI >= c) {
                    rI++;
                    cI = 0;
                }
            }
        }
        return result;
    }
}