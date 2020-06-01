//Sum of Mutated Array Closest to Target
public class P1300 {
    public int findBestValue(int[] arr, int target) {
        int low = 1, high = max(arr) + 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            int sum = sumArray(arr, mid);
            if (sum <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (target - sumArray(arr, low - 1) > (sumArray(arr, low) - target)) {
            return low;
        }
        return low - 1;
    }

    public int sumArray(int[] arr, int k) {
        int sum = 0;
        for (int num : arr) {
            if (num > k)
                sum += k;
            else
                sum += num;
        }
        return sum;
    }

    public int max(int[] arr) {
        int high = 1;
        for (int num : arr) {
            if (num > high)
                high = num;
        }
        return high;
    }
}