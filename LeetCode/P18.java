import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
// 4Sum
public class P18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                int low = j + 1;
                int high = nums.length - 1;
                while (low < high) {
                    if (nums[i] + nums[j] + nums[low] + nums[high] == target) {
                        list.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1])
                            low++;
                        while (low < high && nums[high] == nums[high - 1])
                            high--;
                        low++;
                        high--;
                    } else if (nums[i] + nums[j] + nums[low] + nums[high] < target)
                        low++;
                    else
                        high--;
                }
            }
        }
        return list;
    }
}