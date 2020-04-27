import java.util.Arrays;

// Create Target Array in the Given Order
public class P1389 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int result[] = new int[index.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < index.length; i++) {
            if (result[index[i]] != -1) {
                shiftArray(index[i], result);
            }
            result[index[i]] = nums[i];
        }
        return result;
    }

    public void shiftArray(int index, int[] result) {
        for (int i = result.length - 1; i > index; i--) {
            result[i] = result[i - 1];
        }
    }
}