//  Find First and Last Position of Element in Sorted Array
public class P34 {
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1, i = -1, j = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target) {
                i = j = mid;
                while (i > 0 && nums[i - 1] == target)
                    i--;
                while (j < nums.length - 1 && nums[j + 1] == target)
                    j++;
                return new int[] { i, j };
            } else if (target < nums[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return new int[] { i, j };

    }
}