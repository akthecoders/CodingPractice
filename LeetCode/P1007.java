//Minimum Domino Rotations For Equal Row
public class P1007 {
    public int minDominoRotations(int[] A, int[] B) {
        if (A[0] == B[0]) {
            return count(A, B, A[0]);
        } else {
            return Math.max(count(A, B, A[0]), count(A, B, B[0]));
        }
    }

    public int count(int[] A, int[] B, int target) {
        int n = A.length;
        int countTop = 0;
        int countBottom = 0;

        for (int i = 0; i < n; i++) {
            if (A[i] != target && B[i] != target) {
                return -1;
            }
            if (A[i] != target)
                countTop++;
            if (B[i] != target)
                countBottom++;
        }
        return Math.min(countTop, countBottom);
    }
}