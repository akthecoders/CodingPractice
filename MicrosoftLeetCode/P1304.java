//Find N Unique Integers Sum up to Zero
public class P1304 {
    public int[] sumZero(int n) {
        int result[] = new int[n];
        for (int i = 1; i < n; i++) {
            result[i - 1] = i;
            result[n - i] = -i;
        }
        if (n % 2 == 1) {
            result[n / 2] = 0;
        }
        return result;
    }
}