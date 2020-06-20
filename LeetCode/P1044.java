import java.util.HashSet;
import java.util.Set;

//Longest Duplicate Substring

public class P1044 {
    public String longestDupSubstring(String S) {
        int start = 0;
        int end = S.length() - 1;
        String result = "";
        while (start <= end) {
            int mid = (start + end) / 2;
            String dupSubstring = dupSubstring(S, mid); // check if any dupSubstring of mid size
            if (dupSubstring != null) {
                start = mid + 1;
                result = dupSubstring;
            } else
                end = mid - 1;
        }

        return result;
    }

    private String dupSubstring(String s, int m) {
        int R = 31; // prime
        Set<Long> set = new HashSet<>();

        long patHash = hash(s, m, R);
        set.add(patHash);

        // pre-compute R^(m-1) for use in removing leading digit
        long RM = 1;
        for (int i = 1; i <= m - 1; i++)
            RM = (R * RM);

        for (int i = m; i < s.length(); i++) {
            // Remove leading char, add trailing char, check for match.
            patHash = (patHash - RM * s.charAt(i - m));
            patHash = (patHash * R + s.charAt(i));
            if (!set.add(patHash)) {
                return s.substring(i - m + 1, i + 1);
            }
        }

        return null;
    }

    private long hash(String s, int m, int R) {
        long h = 0;
        for (int j = 0; j < m; j++)
            h = (R * h + s.charAt(j));
        return h;
    }
}