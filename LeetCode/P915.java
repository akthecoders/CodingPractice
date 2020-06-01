//Partition Array into Disjoint Intervals
public class P915 {
    public int partitionDisjoint(int[] A) {
        int N = A.length;
        int minRight[] = new int[N];

        int m = A[N - 1];
        for (int i = N - 1; i >= 0; i--) {
            m = Math.min(m, A[i]);
            minRight[i] = m;
        }

        int maxLeft = 0;
        for (int i = 0; i < N - 1; i++) {
            maxLeft = Math.max(maxLeft, A[i]);
            if (maxLeft <= minRight[i + 1]) {
                return i + 1;
            }
        }
        return -1;
    }
}