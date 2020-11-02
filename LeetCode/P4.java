//Median of Two Sorted Arrays
public class P4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double[] array = new double[nums1.length + nums2.length];
        array = mergeArrays(nums1, nums2, array);
        int length = array.length;
        if (length % 2 == 0) {
            return ((array[length / 2] + array[length / 2 - 1]) / 2);
        } else {
            return array[length / 2];
        }
    }

    private static double[] mergeArrays(int[] nums1, int[] nums2, double[] array) {
        int index1 = 0;
        int index2 = 0;
        int index = 0;

        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1] < nums2[index2]) {
                array[index] = nums1[index1];
                index1++;
            } else {
                array[index] = nums2[index2];
                index2++;
            }
            index++;
        }

        while (index1 < nums1.length) {
            array[index] = nums1[index1];
            index++;
            index1++;
        }

        while (index2 < nums2.length) {
            array[index] = nums2[index2];
            index++;
            index2++;
        }

        return array;
    }
}
// Revision