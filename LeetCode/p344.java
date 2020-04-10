public class p344 {
    public void reverseString(char[] s) {
        int start = 0;
        int end = s.length - 1;

        while (start < end) {
            char tempFirst = s[start];
            s[start] = s[end];
            s[end] = tempFirst;
            start++;
            end--;
        }
    }
}