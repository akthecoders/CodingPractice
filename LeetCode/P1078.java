// Occurrences After Bigram
import java.util.ArrayList;

public class P1078 {
    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split(" ");
        ArrayList<String> set = new ArrayList<>();
        for (int i = 0; i < words.length - 1; i++) {
            String f = words[i];
            String s = "";
            String t = "";
            if (f.equals(first) && i + 1 < words.length) {
                s = words[i + 1];
                if (s.equals(second) && i + 2. < words.length) {
                    t = words[i + 2];
                    set.add(t);
                }
            }
        }
        String[] result = new String[set.size()];
        int index = 0;
        for (String s : set) {
            result[index++] = s;
        }
        return result;
    }
}