//  Longest Common Prefix
public class P14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        int len = strs[0].length();
        for (String word : strs) {
            len = Math.min(word.length(), len);
        }

        String common = "";
        for (int i = 0; i < len; i++) {
            char c = strs[0].charAt(i);
            for (String word : strs) {
                char h = word.charAt(i);
                if (c != h)
                    return common;
            }
            common += c;
        }
        return common;
    }

}