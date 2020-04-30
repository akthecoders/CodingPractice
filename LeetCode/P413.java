// Arithmetic Slices
public class P413 {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3)
            return 0;

        int count = 0;
        int prevCount = 0;
        for (int i = 2; i < A.length; ++i) {
            prevCount = A[i] - A[i - 1] == A[i - 1] - A[i - 2] ? prevCount + 1 : 0;
            count += prevCount;
        }

        return count;
    }
}