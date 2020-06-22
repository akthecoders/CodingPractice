// Check If a Word Occurs As a Prefix of Any Word in a Sentence
public class P1455 {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] split = sentence.split(" ");
        int n = searchWord.length();
        int i = 0;
        for (String word : split) {
            int m = word.length();
            if (m >= n) {
                if (word.indexOf(searchWord) == 0) {
                    return i + 1;
                }
            }
            i++;
        }
        return -1;
    }
}