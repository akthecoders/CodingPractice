import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Greatest Common Divisor of Strings
public class P1071 {
    public String gcdOfStrings(String str1, String str2) {
        return str1.length() < str2.length() ? gcdOfStringsInternal(str1, str2) : gcdOfStringsInternal(str2, str1);
    }

    private String gcdOfStringsInternal(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        List<Integer> factors = factors(len1, len2);
        for (int i : factors) {
            String s = str1.substring(0, i);
            int lns = s.length();
            if (str1.equals(multiply(s, len1 / lns)) && str2.equals(multiply(s, len2 / lns))) {
                return s;
            }
        }
        return "";
    }

    private List<Integer> factors(int x, int y) {
        List<Integer> result = new ArrayList<>();
        if (y % x == 0) {
            result.add(x);
        }
        for (int i = 1; i <= x / 2; i++) {
            if (x % i == 0 && y % i == 0) {
                result.add(i);
            }
        }
        Collections.sort(result, Collections.reverseOrder());
        return result;
    }

    private String multiply(String s, int n) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < n; i++) {
            result.append(s);
        }
        return result.toString();
    }
}