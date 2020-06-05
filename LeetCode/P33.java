// Search in Rotated Sorted Array
public class P33 {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return -1;
        if (nums.length == 1)
            return nums[0] == target ? 0 : -1;

        int n = nums.length;
        if (nums[0] < nums[n - 1])
            return binarySearch(nums, 0, n - 1, target);

        int idx = findPivot(nums, 0, n - 1);
        if (target >= nums[0] && target <= nums[idx - 1]) {
            return binarySearch(nums, 0, idx - 1, target);
        } else if (target >= nums[idx] && target <= nums[n - 1]) {
            return binarySearch(nums, idx, n - 1, target);
        } else {
            return -1;
        }
    }

    public int binarySearch(int[] nums, int si, int ei, int target) {
        if (si > ei)
            return -1;
        int mid = (si + (ei - si) / 2);
        if (nums[mid] == target)
            return mid;

        if (target < nums[mid])
            return binarySearch(nums, si, mid - 1, target);
        else
            return binarySearch(nums, mid + 1, ei, target);
    }

    public int findPivot(int nums[], int si, int ei) {
        int mid = (si + (ei - si) / 2);
        if (mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
            return mid + 1;
        }

        if (nums[mid] < nums[si]) {
            return findPivot(nums, si, mid - 1);
        } else
            return findPivot(nums, mid + 1, ei);

    }
}