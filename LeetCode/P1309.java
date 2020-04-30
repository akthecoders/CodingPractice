// Decrypt String from Alphabet to Integer Mapping
public class P1309 {
    public String freqAlphabets(String s) {
        String[] alphabetical = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
                "r", "s", "t", "u", "v", "w", "x", "y", "z" };
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < s.length()) {
            if (i + 2 < s.length() && s.charAt(i + 2) == '#') {
                sb.append(alphabetical[Integer.parseInt(s.substring(i, i + 2)) - 1]);
                i = i + 3;
            } else {
                sb.append(alphabetical[Integer.parseInt(s.substring(i, i + 1)) - 1]);
                i++;
            }
        }
        return sb.toString();
    }
}