//Previous Permutation With One Swap
public class P1053 {
    public int[] prevPermOpt1(int[] A) {
        for (int left = A.length - 1; left >= 0; left--) {
            int maxVal = -1;
            int maxInd = -1;
            for (int right = left + 1; right < A.length; right++) {
                if (A[left] > A[right] && A[right] > maxVal) {
                    maxVal = A[right];
                    maxInd = right;
                }
            }
            if (maxVal != -1) {
                swap(A, left, maxInd);
                break;
            }
        }
        return A;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}