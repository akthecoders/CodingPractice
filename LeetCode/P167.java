import java.util.HashMap;
// Two Sum II - Input array is sorted
public class P167 {
    public int[] twoSum(int[] numbers, int target) {
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            set.put(numbers[i], i + 1);
        }

        for (int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            if (set.containsKey(Math.abs(target - x))) {
                return new int[] { i + 1, set.get(Math.abs(target - x)) };
            }
        }
        return new int[] {};
    }
}