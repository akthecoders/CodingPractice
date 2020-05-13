// Reverse String II
public class P541 {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        int looper = k;
        int i = 0;
        while(i < s.length()) {
            if(looper == k) {
                for(int l = Math.min((i + k - 1) , s.length() - 1); l >= i; l--) {
                    sb.append(s.charAt(l));
                }
                looper = 0;
                i += k;
            }
            else {
                sb.append(s.charAt(i));
                looper++;
                i++;
            }
        }
        return sb.toString();
    }
}