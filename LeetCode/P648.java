import java.util.HashSet;
import java.util.List;
import java.util.Set;

//Replace Wordsc
public class P648 {
    public String replaceWords(List<String> dict, String sentence) {
        String[] sA = sentence.split(" ");
        Set<String> set = new HashSet<>();

        for (String str : dict) {
            set.add(str);
        }

        for (int i = 0; i < sA.length; i++) {
            String word = sA[i];
            for (int j = 0; j < word.length(); j++) {
                String sub = word.substring(0, j);
                if (set.contains(sub)) {
                    sA[i] = sub;
                    break;
                }

            }
        }

        String ret = "";
        for (int i = 0; i < sA.length - 1; i++) {
            ret += sA[i] + " ";
        }
        ret += sA[sA.length - 1];
        return ret;
    }
}