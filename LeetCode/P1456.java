import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Maximum Number of Vowels in a Substring of Given Length
public class P1456 {
    public int maxVowels(String s, int k) {
        List<Character> list = Arrays.asList('a', 'e', 'i', 'o', 'u');
        Set<Character> vowels = new HashSet<>(list);
        int vCount = 0;
        for (int i = 0; i < k; i++) {
            if (vowels.contains(s.charAt(i)))
                vCount++;
        }

        int l = 0, r = k - 1;
        int mvc = vCount;
        while (r < s.length() - 1) {
            if (vowels.contains(s.charAt(l)))
                vCount--;
            l++;
            r++;
            if (vowels.contains(s.charAt(r)))
                vCount++;
            mvc = Math.max(mvc, vCount);
        }
        return mvc;
    }
}