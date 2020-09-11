import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// Word Ladder
public class P127 {
    int min = Integer.MAX_VALUE;

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (wordList.size() == 0)
            return 0;
        if (beginWord.length() == 0 || endWord.length() == 0)
            return 0;
        if (beginWord.length() == 1)
            return 2;

        Set<String> set = new HashSet<>();
        for (String w : wordList)
            set.add(w);

        return bfs(beginWord, endWord, set);
    }

    public int bfs(String beginWord, String endWord, Set<String> wordList) {
        if (wordList.size() == 0)
            return 0;
        if (!wordList.contains(endWord))
            return 0;
        int level = 0;
        int n = beginWord.length();

        Queue<String> q = new LinkedList<>();
        q.add(beginWord);

        while (!q.isEmpty()) {
            level++;
            int sizeQ = q.size();

            for (int i = 0; i < sizeQ; i++) {
                char[] word = q.poll().toCharArray();

                for (int pos = 0; pos < n; ++pos) {
                    char orig_char = word[pos];
                    for (char c = 'a'; c <= 'z'; c++) {
                        word[pos] = c;
                        if (String.valueOf(word).equals(endWord))
                            return level + 1;
                        if (!wordList.contains(String.valueOf(word)))
                            continue;
                        wordList.remove(String.valueOf(word));
                        q.add(String.valueOf(word));
                    }
                    word[pos] = orig_char;
                }
            }
        }
        return 0;
    }
}
