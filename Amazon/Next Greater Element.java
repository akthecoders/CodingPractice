import java.util.HashMap;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1.length == 0)
            return new int[] {};
        if (nums2.length == 0)
            return new int[] {};

        HashMap<Integer, Integer> next = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        stack.push(nums2[0]);

        for (int i = 1; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= nums2[i]) {
                next.put(stack.peek(), nums2[i]);
                stack.pop();
            }
            stack.push(nums2[i]);
        }

        while (!stack.isEmpty()) {
            next.put(stack.peek(), -1);
            stack.pop();
        }

        int result[] = new int[nums1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = next.get(nums1[i]);
        }
        return result;
    }
}