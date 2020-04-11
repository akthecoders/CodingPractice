
public class P1313 {
    public int[] decompressRLElist(int[] nums) {
        int size = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            size += nums[i];
        }
        int output[] = new int[size];
        int count = 0;
        for (int i = 0; i < nums.length; i = i + 2) {
            for (int j = 0; j < nums[i]; j++) {
                output[count++] = nums[i + 1];
            }
        }
        return output;
    }
}
