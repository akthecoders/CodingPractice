//Maximum Points You Can Obtain from Cards
public class P1423 {
    public int maxScore(int[] cardPoints, int k) {
        int sum = getSum(cardPoints);
        int minSum = getMinSumSubArray(cardPoints, cardPoints.length - k);
        return sum - minSum;
    }

    public int getMinSumSubArray(int arr[], int k) {
        int lft = 0;
        int rgt = 0;
        int ans = Integer.MAX_VALUE, currentSum = 0;
        while (lft < arr.length && rgt < arr.length) {
            while (rgt - lft < k) {
                currentSum += arr[rgt++];
            }
            ans = Math.min(ans, currentSum);
            currentSum -= arr[lft++];
        }
        return ans;
    }

    public int getSum(int cardPoints[]) {
        int ans = 0;
        for (int x : cardPoints) {
            ans += x;
        }
        return ans;
    }
}