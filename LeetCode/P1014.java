//Best Sightseeing Pair
public class P1014 {
    public int maxScoreSightseeingPair(int[] A) {
        int n = A.length;
        int maxRight = A[n - 1] - (n - 1);
        int overAllGain = Integer.MIN_VALUE;
        for (int i = n - 2; i >= 0; i--) {
            maxRight = Math.max(maxRight, A[i + 1] - (i + 1));
            overAllGain = Math.max(overAllGain, A[i] + i + maxRight);
        }
        return overAllGain;
    }
}