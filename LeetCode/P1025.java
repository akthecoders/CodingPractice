// Divisor Game
public class P1025 {
    public boolean divisorGame(int N) {
        if (N == 1 || N == 3)
            return false;
        if (N == 2)
            return true;

        int dp[] = new int[N + 1];

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 0;

        for (int i = 4; i <= N; i++) {
            for (int j = 1; j <= i / 2 && i % j == 0; j++) {
                if (dp[i - j] == 0) {
                    dp[i] = 1;
                }
            }
        }

        return dp[N] == 1;
    }
}