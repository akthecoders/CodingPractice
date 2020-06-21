//Minimum Number of K Consecutive Bit Flips
public class P995 {
    public int minKBitFlips(int[] A, int K) {
        int N = A.length;
        int[] hint = new int[N];
        int ans = 0, flip = 0;

        for (int i = 0; i < N; i++) {
            flip ^= hint[i];
            if (A[i] == flip) {
                ans++;
                if (i + K > N)
                    return -1;
                flip ^= 1;
                if (i + K < N)
                    hint[i + K] ^= 1;
            }
        }
        return ans;
    }
}