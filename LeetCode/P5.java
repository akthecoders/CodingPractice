//Longest Palindromic Substrings
public class P5 {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n == 0)
            return s;
        if (n == 1)
            return s;
        boolean table[][] = new boolean[n][n];

        int maxLength = 1;
        for (int i = 0; i < n; ++i)
            table[i][i] = true;

        int start = 0;
        for (int i = 0; i < n - 1; ++i) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                table[i][i + 1] = true;
                start = i;
                maxLength = 2;
            }
        }

        for (int k = 3; k <= n; ++k) {
            for (int i = 0; i < n - k + 1; ++i) {
                int j = i + k - 1;
                char en = s.charAt(j);
                char st = s.charAt(i);

                if (en == st && table[i + 1][j - 1]) {
                    table[i][j] = true;
                    if (k > maxLength) {
                        maxLength = k;
                        start = i;
                    }
                }

            }
        }

        return s.substring(start, start + maxLength);
    }
}

//Revision