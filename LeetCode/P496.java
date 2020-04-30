// Next Greater Element I
import java.util.*;
public class P496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hMap = new HashMap<>();

        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!st.isEmpty() && st.peek() < nums2[i]) {
                hMap.put(st.pop(), nums2[i]);
            }
            st.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = hMap.containsKey(nums1[i]) ? hMap.get(nums1[i]) : -1;
        }

        return nums1;
    }
}