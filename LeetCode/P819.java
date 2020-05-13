//Most Common Word
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P819 {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.replaceAll("\\p{Punct}", " ").toLowerCase();

        int max = 0;
        String mostCommon = "";

        Map<String, Integer> map = new HashMap<>();
        for (String str : paragraph.split(" +")) {
            if (!isBanned(banned, str)) {
                map.put(str, map.getOrDefault(str, 0) + 1);
                if (map.get(str) > max) {
                    mostCommon = str;
                    max = map.get(str);
                }
            }

        }
        return mostCommon;
    }

    private boolean isBanned(String[] array, String str) {
        List<String> list = Arrays.asList(array);
        return list.contains(str);
    }
}