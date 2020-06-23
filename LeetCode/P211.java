import java.util.HashMap;
import java.util.Map;

//Add and Search Word - Data structure design
public class P211 {
    Map<Character, P211> children;
    boolean isWord = false;

    /** Initialize your data structure here. */
    public P211() {
        children = new HashMap<>();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        if (word == null || word.length() == 0)
            return;
            P211 current = this;
        for (Character ch : word.toCharArray()) {
            if (!current.children.containsKey(ch))
                current.children.put(ch, new P211());
            current = current.children.get(ch);
        }
        current.isWord = true;

    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot
     * character '.' to represent any one letter.
     */
    public boolean search(String word) {
        if (word == null || word.length() == 0)
            return false;
            P211 current = this;

        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '.') {
                if (i == word.length() - 1) {
                    for (char wd : current.children.keySet()) {
                        if (current.children.get(wd).isWord)
                            return true;
                    }
                    return false;
                } else {
                    for (char w : current.children.keySet()) {
                        if (current.children.get(w).search(word.substring(i + 1)))
                            return true;
                    }
                    return false;
                }
            } else {
                if (current.children.containsKey(c))
                    current = current.children.get(c);
                else
                    return false;
            }
        }
        return current.isWord;
    }
}