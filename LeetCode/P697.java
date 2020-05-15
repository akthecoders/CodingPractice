//Degree of an Array
import java.util.HashMap;

public class P697 {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> numCount = new HashMap<>();
        int degree = 0;
        HashMap<Integer, Integer> firstSeen = new HashMap<>();
        int minLength = 0;
        for (int i = 0; i < nums.length; i++) {
            firstSeen.putIfAbsent(nums[i], i);
            numCount.put(nums[i], numCount.getOrDefault(nums[i], 0) + 1);
            if (numCount.get(nums[i]) > degree) {
                degree = numCount.get(nums[i]);
                minLength = i - firstSeen.get(nums[i]) + 1;
            } else if (numCount.get(nums[i]) == degree) {
                minLength = Math.min(minLength, i - firstSeen.get(nums[i]) + 1);
            }
        }
        return minLength;
    }
}