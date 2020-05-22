//Check If All 1's Are at Least Length K Places Away
public class P1437 {
    public boolean kLengthApart(int[] nums, int k) {
        int prev = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (prev != -1) {
                    int diff = i - prev - 1;
                    if (diff < k) {
                        return false;
                    }
                    prev = i;
                } else {
                    prev = i;
                }
            }
        }
        return true;
    }
}