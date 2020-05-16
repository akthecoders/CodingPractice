//Maximum Sum Circular Subarray
public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] A) {
        int maxStraightSum = Integer.MIN_VALUE;
        int minStraightSum = Integer.MAX_VALUE;
        int arraySum = 0;
        int tempMax = 0;
        int tempMin = 0;

        for (int x : A) {
            arraySum += x;
            tempMax += x;
            maxStraightSum = Math.max(maxStraightSum, tempMax);
            tempMax = tempMax < 0 ? 0 : tempMax;

            tempMin += x;
            minStraightSum = Math.min(minStraightSum, tempMin);
            tempMin = tempMin > 0 ? 0 : tempMin;
        }

        if (arraySum == minStraightSum)
            return maxStraightSum;
        return Math.max(maxStraightSum, arraySum - minStraightSum);
    }
}