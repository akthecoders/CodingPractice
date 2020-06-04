import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Majority Element II
public class P229 {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0)
            return res;
        int n = nums.length;
        int r = n / 3;
        Arrays.sort(nums);
        int left = 0;
        for (int i = 0; i < n; i++) {
            while (i < n - 1 && nums[i] == nums[i + 1])
                i++;
            if ((i - left + 1) > r) {
                res.add(nums[i]);
            }
            left = i + 1;
        }
        return res;
    }
}