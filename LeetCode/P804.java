//  Unique Morse Code Words
import java.util.*;
public class P804 {
    public int uniqueMorseRepresentations(String[] words) {
        String[] map = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--",
                "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.." };

        int base = 97;

        Set<String> uS = new HashSet<String>();
        for (int i = 0; i < words.length; i++) {
            String str = "";
            for (int j = 0; j < words[i].length(); j++) {
                int n = (int) words[i].charAt(j) - base;
                str += map[n];
            }
            uS.add(str);
        }

        return uS.size();
    }
}