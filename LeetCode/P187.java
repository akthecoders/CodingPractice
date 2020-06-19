import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//Repeated DNA Sequences
public class P187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>();
        if (s.length() < 11)
            return list;

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length() - 10 + 1; i++) {
            String str = s.substring(i, i + 10);
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        for (Map.Entry<String, Integer> itr : map.entrySet()) {
            String key = itr.getKey();
            int value = itr.getValue();

            if (value > 1) {
                list.add(key);
            }
        }
        return list;

    }
}