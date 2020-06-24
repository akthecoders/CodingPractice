// XOR Operation in an Array
public class P1486 {
    public int xorOperation(int n, int start) {
        if (n == 0)
            return 0;
        if (n == 1)
            return start;

        int res = start;
        for (int i = 1; i < n; i++) {
            res ^= start + 2 * i;
        }
        return res;
    }
}