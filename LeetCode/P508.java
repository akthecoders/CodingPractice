//Most Frequent Subtree Sum
import java.util.*;
public class P508 {
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer, Integer> hMap = new HashMap<>();
        helper(root, hMap);
        int maxFreq = 0;
        int noOfMaxFreq = 0;
        for (Map.Entry<Integer, Integer> itr : hMap.entrySet()) {
            int freq = itr.getValue();
            System.out.println("freq " + freq);
            if (freq > maxFreq) {
                maxFreq = freq;
                noOfMaxFreq = 1;
            } else if (freq == maxFreq) {
                noOfMaxFreq++;
            }
        }
        int res[] = new int[noOfMaxFreq];
        int index = 0;
        for (Map.Entry<Integer, Integer> itr : hMap.entrySet()) {
            int freq = itr.getValue();
            int sum = itr.getKey();
            if (freq == maxFreq) {
                res[index++] = sum;
            }
        }
        return res;
    }

    public int helper(TreeNode root, HashMap<Integer, Integer> hMap) {
        if (root == null)
            return 0;

        int left = helper(root.left, hMap);
        int right = helper(root.right, hMap);

        int currSum = root.val + left + right;
        if (hMap.containsKey(currSum)) {
            hMap.put(currSum, hMap.get(currSum) + 1);
        } else {
            hMap.put(currSum, 1);
        }
        return currSum;
    }
}