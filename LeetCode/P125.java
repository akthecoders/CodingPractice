//Valid Palindrome
public class P125 {
    public boolean isPalindrome(String s) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isLetterOrDigit(s.charAt(i))) {
                str.append(s.charAt(i));
            }
        }

        return str.toString().toLowerCase().equals(str.reverse().toString().toLowerCase());
    }
}