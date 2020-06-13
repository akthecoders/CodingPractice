import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//Uncommon Words from Two Sentences
public class P884 {
    public String[] uncommonFromSentences(String A, String B) {
        String[] Aarr = A.split(" ");
        String[] Barr = B.split(" ");

        HashMap<String, Integer> map = new HashMap<>();
        for (String str : Aarr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        for (String str : Barr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (String word : map.keySet()) {
            if (map.get(word) == 1)
                list.add(word);
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}