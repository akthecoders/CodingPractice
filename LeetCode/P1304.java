//Find N Unique Integers Sum up to Zero
public class P1304 {
    public int[] sumZero(int n) {
        int[] result = new int[n];
        if (n <= 1)
            return result;
        int mid = n / 2;
        int val = -mid;
        if (n % 2 != 0) {
            for (int i = 0; i < n; i++) {
                result[i] = val++;
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (val == 0)
                    result[i] = mid;
                else
                    result[i] = val;
                val++;
            }
        }
        return result;
    }
}