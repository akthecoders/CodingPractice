//Partition Array for Maximum Sum
public class P1043 {
    public static void main(String[] args) {
        int[] A = {1,15,7,9,2,5,10};
        int K = 3;
        System.out.println(maxSumAfterPartitioning(A, K));
    }

    public static int maxSumAfterPartitioning(int[] A, int K) {
        int[] dp = new int[A.length + 1];
        int maxSoFar = 0;
        dp[0] = 0;
        for(int i = 1; i <= A.length; i++) {
            maxSoFar = A[i - 1];
            for(int j = 1; j <= Math.min(K, i); j++) {
                dp[i] = Math.max(dp[i] , dp[i - j] + maxSoFar * j);
                if(i - j - 1 >= 0) {
                    maxSoFar = Math.max(maxSoFar, A[i-j-1]);
                }
            }
        }

        return dp[A.length];
    }
}