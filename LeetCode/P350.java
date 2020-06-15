import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Intersection of Two Arrays II
public class P350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;

        List<Integer> list = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                list.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int result[] = new int[list.size()];
        i = 0;
        for (int x : list)
            result[i++] = x;
        return result;
    }
}