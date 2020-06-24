//Peak Index in a Mountain Array
public class P852 {
    public int peakIndexInMountainArray(int[] A) {
        int max = 0;
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (max < A[i]) {
                max = A[i];
                index = i;
            }
        }
        return index;
    }
}