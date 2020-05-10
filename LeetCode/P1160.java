import java.util.HashMap;
import java.util.Map;

// Find Words That Can Be Formed by Characters
public class P1160 {
    public int countCharacters(String[] words, String chars) {
        int length = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            map.put(chars.charAt(i), map.getOrDefault(chars.charAt(i), 0) + 1);
        }
        for (String str : words) {
            Map<Character, Integer> childMap = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                childMap.put(str.charAt(i), childMap.getOrDefault(str.charAt(i), 0) + 1);
            }
            int j = 0;
            for (Character ch : childMap.keySet()) {
                if (!map.containsKey(ch) || childMap.get(ch) > map.get(ch))
                    break;
                else
                    j += childMap.get(ch);
            }
            if (j == str.length())
                length = length + str.length();
        }
        return length;
    }
}