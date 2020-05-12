//Reverse Words in a String III
public class P557 {
    public String reverseWords(String s) {
        int start = 0;
        int end = 0;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] != ' ') {
                start = i;
                while (i < charArray.length && charArray[i] != ' ') {
                    i++;
                }
                end = i - 1;
                while (start < end) {
                    char t = charArray[start];
                    charArray[start] = charArray[end];
                    charArray[end] = t;
                    start++;
                    end--;
                }
            }
        }
        return new String(charArray);
    }
}