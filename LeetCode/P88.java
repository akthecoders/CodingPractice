import java.util.Arrays;

//Merge Sorted Array
public class P88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        for (int i = 0, index = m; i < nums2.length; i++, index++)
            nums1[index] = nums2[i];
        Arrays.sort(nums1);
    }
}