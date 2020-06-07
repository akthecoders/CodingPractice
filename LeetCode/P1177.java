import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Can Make Palindrome from Substring
public class P1177 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        List<Boolean> res = new ArrayList<>();
        int[][] counts = prepareCounts(s);
        for (int i = 0; i < queries.length; ++i) {
            int left = queries[i][0];
            int right = queries[i][1];
            int k = queries[i][2];
            res.add(canFormPalidrome(counts, left, right, k));
        }
        return res;
    }

    private int[][] prepareCounts(String s) {
        // each row in this matrix stores the number of appearance of each character in
        // substring [0, row] where 0 <= row <= s.length() - 1
        int[][] res = new int[s.length()][26];
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            int curIndex = s.charAt(i) - 'a';
            counts[curIndex] += 1;
            res[i] = Arrays.copyOf(counts, 26);
        }
        return res;
    }

    // Since we could rearrange the substring, then to determine whether a substring
    // is a valid palidrome,
    // we just need to make sure allowed replacements k >= number of odd appearances
    // / 2,
    // as we only need to replace half of the odd appearances to make it even
    private boolean canFormPalidrome(int[][] counts, int left, int right, int k) {
        if (left == right || right - left + 1 <= k)
            return true;
        // for odd length substring, we dont need to replace the middle character
        int flag = (right - left + 1) % 2 == 0 ? 0 : -1;
        int oddCount = 0;
        // calculate number of characters that only appeared odd times
        for (int i = 0; i < 26; ++i) {
            oddCount += left == 0 ? counts[right][i] % 2 : (counts[right][i] - counts[left - 1][i]) % 2;
        }
        return (oddCount + flag) / 2 <= k;
    }
}