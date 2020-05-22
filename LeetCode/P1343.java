//Number of Sub-arrays of Size K and Average Greater than or Equal to Threshold
public class P1343 {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0, right = 0, sum = 0, result = 0;
        while (right < arr.length) {
            sum += arr[right];
            if (right - left + 1 == k) {
                if (sum / k >= threshold) {
                    result++;
                }
                sum -= arr[left];
                left++;
            }
            right++;
        }
        return result;
    }
}