//Reverse Words in a String III
public class P557 {
    public String reverseWords(String s) {
        if (s.length() == 0)
            return s;
        s = s.trim();
        int start = 0;
        int end = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        while (start < n && end < n) {
            if (s.charAt(start) == ' ') {
                sb.append(' ');
            }
            while (start < n && s.charAt(start) == ' ') {
                start++;
                end++;
            }
            while (end < n && s.charAt(end) != ' ') {
                end++;
            }
            int tE = end - 1;

            while (start <= tE) {
                sb.append(s.charAt(tE));
                tE--;
            }
            start = end;
        }
        return sb.toString();
    }
}