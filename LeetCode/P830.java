import java.util.ArrayList;
import java.util.List;

//Positions of Large Groups
public class P830 {
    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> result = new ArrayList<>();
        if (S.length() < 3)
            return result;
        int left = 0;
        int right = 0;
        while (left < S.length() && right < S.length()) {
            while (right + 1 < S.length() && S.charAt(right) == S.charAt(right + 1)) {
                right++;
            }
            int diff = right - left + 1;
            if (diff >= 3) {
                ArrayList<Integer> pair = new ArrayList<>();
                pair.add(left);
                pair.add(right);
                result.add(pair);
            }
            right++;
            left = right;
        }
        return result;
    }
}