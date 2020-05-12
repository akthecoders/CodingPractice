//Goat Latin
public class P824 {
    public String toGoatLatin(String S) {
        String[] words = null;
        words = S.split(" ");
        String S1 = "";
        String t = "";
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            char bt = str.charAt(0);
            if (bt == 'a' || bt == 'e' || bt == 'i' || bt == 'o' || bt == 'u' || bt == 'A' || bt == 'E' || bt == 'I'
                    || bt == 'O' || bt == 'U') {
                S1 = str + "ma";
                for (int j = 0; j < i + 1; j++) {
                    S1 = S1 + "a";
                }
            } else {

                S1 = str.substring(1) + String.valueOf(bt) + "ma";
                for (int j = 0; j < i + 1; j++) {
                    S1 = S1 + "a";
                }
            }
            t = t + S1 + " ";
        }

        return t.trim();
    }
}