import java.util.Arrays;
import java.util.List;

//Maximum Length of a Concatenated String with Unique Characters
public class P1239 {
    int res = 0;

    public int maxLength(List<String> arr) {
        if (arr == null || arr.size() < 1)
            return 0;
        solve(arr, 0, new int[26], 0);
        return res;
    }

    public void solve(List<String> arr, int start, int[] set, int size) {
        if (start == arr.size()) {
            res = Math.max(res, size);
            return;
        }

        for (int i = start; i < arr.size(); i++) {
            boolean dup = false;
            int newSet[] = Arrays.copyOf(set, 26);
            String str = arr.get(i);
            for (int j = 0; j < str.length(); j++) {
                char c = str.charAt(j);
                if (newSet[c - 'a'] != 0) {
                    dup = true;
                    break;
                } else {
                    newSet[c - 'a']++;
                }
            }
            if (dup) {
                solve(arr, i + 1, set, size);
            } else {
                solve(arr, i + 1, newSet, size + str.length());
            }
        }
    }
}