import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
//Most Common Word
public class P819_r {
    public String mostCommonWord(String paragraph, String[] banned) {
        String normalize = paragraph.replaceAll("[^a-zA-Z0-9]", " ").toLowerCase();

        String[] words = normalize.split("\\s+");
        Set<String> bannedWords = new HashSet<>();
        for (String word : banned)
            bannedWords.add(word);

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            if (!bannedWords.contains(word))
                wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }

        return Collections.max(wordCount.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}
