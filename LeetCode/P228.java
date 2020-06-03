import java.util.ArrayList;
import java.util.List;

//Summary Ranges
public class P228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> ret = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            StringBuilder str = new StringBuilder();
            str.append(nums[i]);
            int j;
            for (j = i + 1; j < nums.length; j++)
                if (nums[j] != nums[i] + j - i)
                    break;
            if (j != i + 1) {
                str.append("->").append(nums[i] + j - i - 1);
            }
            ret.add(str.toString());
            i = j - 1;
        }
        return ret;
    }
}