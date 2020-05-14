//Count Largest Group
public class P1399 {
    public int countLargestGroup(int n) {
        int[] maxSum = new int[37];
        int maxSize = 0;
        for (int i = 1; i <= n; i++) {
            int dSum = digitSum(i);
            maxSum[dSum]++;
            maxSize = Math.max(maxSize, maxSum[dSum]);
        }

        int res = 0;
        for (int value : maxSum) {
            if (value == maxSize)
                res++;
        }
        return res;
    }

    public int digitSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i /= 10;
        }
        return sum;
    }
}