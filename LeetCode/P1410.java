// HTML Entity Parser
import java.util.*;
public class P1410 {
    public String entityParser(String text) {
        StringBuilder res = new StringBuilder();
        char cs[] = new char[] { 'a', 'q', 'g', 'l', 'f' };
        Set<Character> set = new HashSet<>();
        Map<String, String> map = new HashMap<>();
        map.put("quot", "\"");
        map.put("apos", "'");
        map.put("amp", "&");
        map.put("gt", ">");
        map.put("lt", "<");
        map.put("frasl", "/");
        for (char c : cs) {
            set.add(c);
        }
        int n = text.length();
        for (int i = 0; i < n; i++) {
            char c = text.charAt(i);
            if (c == '&' && i < n - 1 && set.contains(text.charAt(i + 1))) {
                StringBuilder sb = new StringBuilder();
                for (int j = i + 1; j < n; j++) {
                    char curr = text.charAt(j);
                    if (curr == ';') {
                        String s = sb.toString();
                        if (map.containsKey(s)) {
                            res.append(map.get(s));
                            i = j;
                        } else {
                            res.append(c);
                        }
                        break;
                    }
                    if (sb.length() > 5 || !Character.isLetter(curr)) {
                        res.append(c);
                        break;
                    }
                    sb.append(curr);
                }
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}