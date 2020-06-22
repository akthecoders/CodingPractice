import java.util.ArrayList;
import java.util.List;

//Letter Case Permutation
/**
 * P784
 */
public class P784 {
    public List<String> letterCasePermutation(String S) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        permute(S, 0, sb, result);
        return result;
    }

    public void permute(String S, int pos, StringBuilder sb, List<String> res) {
        if (pos >= S.length()) {
            res.add(sb.toString());
            return;
        }

        char c = S.charAt(pos);
        if (Character.isDigit(c)) {
            permute(S, pos + 1, sb.append(c), res);
            sb.setLength(sb.length() - 1);
        } else {
            char upper = Character.toUpperCase(c);
            char lower = Character.toLowerCase(c);

            permute(S, pos + 1, sb.append(upper), res);
            sb.setLength(sb.length() - 1);

            permute(S, pos + 1, sb.append(lower), res);
            sb.setLength(sb.length() - 1);
        }
    }

}