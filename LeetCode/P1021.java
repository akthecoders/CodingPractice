// Remove Outermost Parentheses
public class P1021 {
    public String removeOuterParentheses(String S) {
        int balance = 0;
        StringBuilder sb = new StringBuilder(S);

        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                if (balance == 0) {
                    sb.deleteCharAt(i);
                    balance--;
                    i--;
                } else {
                    balance--;
                }
            } else {
                balance++;
                if (balance == 0) {
                    sb.deleteCharAt(i);
                    i--;
                }
            }
        }

        return sb.toString();
    }
}