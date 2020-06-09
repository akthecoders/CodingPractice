//Ugly Number II
public class P264 {
    public int nthUglyNumber(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;

        int i = 0, j = 0, k = 0, h = 1;
        while (h <= n) {
            int multiplyTwo = result[i] * 2;
            int multiplyThree = result[j] * 3;
            int multiplyFive = result[k] * 5;

            int min = Math.min(multiplyTwo, Math.min(multiplyThree, multiplyFive));
            result[h++] = min;

            if (Integer.compare(min, multiplyTwo) == 0) {
                i++;
            }

            if (Integer.compare(min, multiplyThree) == 0) {
                j++;
            }

            if (Integer.compare(min, multiplyFive) == 0) {
                k++;
            }
        }

        return result[n - 1];
    }
}