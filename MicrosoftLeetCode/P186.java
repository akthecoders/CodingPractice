//Reverse Words in a String II
public class P186 {
    public void reverseWords(char[] s) {
        if (s.length == 0)
            return;
        reverse(s, 0, s.length - 1);

        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverse(s, start, end - 1);
                start = i + 1;
                end = i + 1;
                i++;
            }
            end++;
        }
        if (start < s.length) {
            reverse(s, start, s.length - 1);
        }
    }

    public void reverse(char[] s, int start, int end) {
        while (start < end) {
            char t = s[start];
            s[start] = s[end];
            s[end] = t;
            start++;
            end--;
        }
    }
}