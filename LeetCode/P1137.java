// N-th Tribonacci Number
public class P1137 {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return helper(0, 1, 1, n, 2);
    }

    public int helper(int t1, int t2, int t3, int n, int curr) {
        if (curr == n) {
            return t3;
        }
        return helper(t2, t3, (t1 + t2 + t3), n, curr + 1);
    }
}