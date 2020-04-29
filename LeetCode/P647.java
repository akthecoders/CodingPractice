// Palindromic Substrings
public class P647 {
    public int countSubstrings(String s) {
        int res = 0;
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j < s.length() - i; j++) {
                int st = j;
                int en = j + i;
                String sub = s.substring(st, en + 1);
                if (isPalindrome(sub)) {
                    res++;
                }
            }
        }
        return res;
    }

    boolean isPalindrome(String str) {
        int i = 0, j = str.length() - 1;
        while (i < j) {
            if (str.charAt(i) != str.charAt(j))
                return false;
            i++;
            j--;
        }
        return true;
    }
}