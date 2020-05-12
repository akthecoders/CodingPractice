//Remove Palindromic Subsequences
public class P1332 {
    public int removePalindromeSub(String s) {
        if (s.length() == 0)
            return 0;
        boolean palindrome = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                palindrome = false;
                break;
            }
        }
        return palindrome ? 1 : 2;
    }
}