//Maximum Binary Tree
public class P654 {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxTree(nums);
    }

    TreeNode maxTree(int[] nums) {
        int maxIndex = maxIndex(nums);
        TreeNode node = new TreeNode(nums[maxIndex]);
        if (maxIndex > 0)
            node.left = maxTree(subarray(0, maxIndex, nums));
        if (maxIndex < nums.length - 1)
            node.right = maxTree(subarray(maxIndex + 1, nums.length, nums));
        return node;
    }

    int[] subarray(int start, int end, int[] nums) {
        int[] subarray = new int[(end - start)];
        for (int i = 0; i + start < end; i++) {
            subarray[i] = nums[i + start];
        }
        return subarray;
    }

    int maxIndex(int[] nums) {
        int max = nums[0];
        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }
        return index;
    }
}