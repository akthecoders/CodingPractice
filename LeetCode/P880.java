// Decoded String at Index
public class P880 {
    public String decodeAtIndex(String S, int K) {
        long strLength = 0;
        for (int i = 0; i < S.length(); i++) {
            Character c = S.charAt(i);
            if (Character.isDigit(c)) {
                strLength *= (c - '0');
            } else
                strLength++;
        }

        if (strLength == 0) {
            return null;
        }

        for (int i = S.length() - 1; i >= 0; i--) {
            K = (int) (K % strLength);

            if (K == 0 && Character.isLetter(S.charAt(i))) {
                return Character.toString(S.charAt(i));
            }

            if (Character.isDigit(S.charAt(i))) {
                strLength = strLength / (S.charAt(i) - '0');
            } else {
                strLength--;
            }
        }
        return null;
    }
}