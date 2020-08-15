//Merge Sorted Array
public class P88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int temp[] = new int[nums1.length];

        int i = 0;
        int j = 0;
        int index = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                temp[index++] = nums1[i++];
            } else {
                temp[index++] = nums2[j++];
            }
        }

        while (i < m) {
            temp[index++] = nums1[i++];
        }

        while (j < n) {
            temp[index++] = nums2[j++];
        }

        index = 0;
        for (int x : temp)
            nums1[index++] = x;
    }
}