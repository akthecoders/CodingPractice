import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//Word Ladder II
public class P126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> dict = new HashSet<>(wordList);
        List<List<String>> res = new ArrayList<>();
        if (!dict.contains(endWord))
            return res;
        Map<String, List<String>> map = new HashMap<>();
        Set<String> startWords = new HashSet<>();
        startWords.add(beginWord);
        bfs(startWords, endWord, map, dict);

        List<String> list = new ArrayList<>();
        list.add(beginWord);
        dfs(res, list, beginWord, endWord, map);
        return res;
    }

    public void dfs(List<List<String>> res, List<String> list, String word, String endWord,
            Map<String, List<String>> map) {
        if (word.equals(endWord)) {
            res.add(new ArrayList<>(list));
            return;
        }

        if (map.get(word) == null)
            return;

        for (String next : map.get(word)) {
            list.add(next);
            dfs(res, list, next, endWord, map);
            list.remove(list.size() - 1);
        }
    }

    public void bfs(Set<String> startWords, String endWord, Map<String, List<String>> map, HashSet<String> dict) {
        if (startWords.size() == 0)
            return;
        Set<String> tmp = new HashSet<>();
        dict.removeAll(startWords);
        boolean finish = false;

        for (String s : startWords) {
            char[] chrs = s.toCharArray();
            for (int i = 0; i < chrs.length; i++) {
                char oldChar = chrs[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    chrs[i] = j;
                    String word = new String(chrs);
                    if (dict.contains(word)) {
                        if (word.equals(endWord)) {
                            finish = true;
                        } else {
                            tmp.add(word);
                        }

                        if (map.get(s) == null) {
                            map.put(s, new ArrayList<>());
                        }

                        map.get(s).add(word);
                    }

                }
                chrs[i] = oldChar;
            }
        }
        if (!finish) {
            bfs(tmp, endWord, map, dict);
        }
    }
}