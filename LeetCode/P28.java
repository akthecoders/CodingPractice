//Implement strStr()
public class P28 {
    public int strStr(String haystack, String needle) {
        if (haystack.length() == 0 && needle.length() == 0)
            return 0;
        if (haystack.length() == 0)
            return -1;
        if (needle.length() == 0)
            return 0;
        if (needle.length() > haystack.length())
            return -1;

        int hc = 0;
        int nc = 0;
        int start = 0;
        while (hc < haystack.length() && nc < needle.length()) {
            char h = haystack.charAt(hc);
            char n = needle.charAt(nc);
            if (h == n) {
                start = hc;
                int thc = hc;
                int tnc = nc;
                while (thc < haystack.length() && tnc < needle.length() && haystack.charAt(thc) == needle.charAt(tnc)) {
                    thc++;
                    tnc++;
                }
                if (tnc >= needle.length()) {
                    return start;
                }
            }
            hc++;
            nc = 0;

        }
        return -1;
    }
}