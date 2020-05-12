import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

//String Matching in an Array
public class P1408 {
    public List<String> stringMatching(String[] words) {
        Arrays.sort(words, Comparator.comparingInt(String::length));
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int start = i + 1;
            while (start < words.length) {
                if (words[start].contains(word)) {
                    list.add(word);
                    break;
                }
                start++;
            }
        }
        return list;
    }
}