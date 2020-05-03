// Ransome Note
import java.util.*;
public class RansomNote03 {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] str1 = ransomNote.toCharArray();
        char[] str2 = magazine.toCharArray();

        HashMap<Character, Integer> h1 = new HashMap<>();
        HashMap<Character, Integer> h2 = new HashMap<>();

        for (char c : str1) {
            if (h1.containsKey(c)) {
                h1.put(c, h1.get(c) + 1);
            } else {
                h1.put(c, 1);
            }
        }
        for (char c : str2) {
            if (h2.containsKey(c)) {
                h2.put(c, h2.get(c) + 1);
            } else {
                h2.put(c, 1);
            }
        }

        for(Map.Entry<Character, Integer> mapElement : h1.entrySet()) {
            char c = (char) mapElement.getKey();
            int freq = (int) mapElement.getValue();
            if (h2.containsKey(c)) {
                int freq2 = h2.get(c);
                if (freq2 < freq) {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;

    }
}