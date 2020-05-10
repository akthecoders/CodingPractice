//FindtheTownJudge
public class FindtheTownJudge {
    public int findJudge(int N, int[][] trust) {
        if (trust.length <= 0) {
            return N;
        }
        int freq[] = new int[N];
        for (int i = 0; i < trust.length; i++) {
            freq[trust[i][1] - 1]++;
            freq[trust[i][0] - 1]--;
        }

        for (int i = 0; i < N; i++) {
            if (freq[i] == N - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}