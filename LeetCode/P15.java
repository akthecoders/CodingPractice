import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//3Sum
public class P15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i -= -1) {
            if (i == 0 || i > 0 && nums[i] != nums[i - 1]) {
                int k = i + 1;
                int j = nums.length - 1;
                while (k < j) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        result.add(Arrays.asList(nums[i], nums[k], nums[j]));
                        while (k < j && nums[k] == nums[k + 1]) {
                            k++;
                        }
                        while (k < j && nums[j] == nums[j - 1]) {
                            j--;
                        }
                        k++;
                        j--;
                    } else if ((nums[k] + nums[j] + nums[i]) > 0) {
                        j--;
                    } else {
                        k++;
                    }
                }
            }
        }
        return result;
    }
}