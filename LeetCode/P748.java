//Shortest Completing Word
public class P748 {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] map = new int[26];
        licensePlate = licensePlate.toLowerCase();
        for (int i = 0; i < licensePlate.length(); i++) {
            char c = licensePlate.charAt(i);
            if (Character.isLetter(c)) {
                map[c - 'a']++;
            }
        }
        int wordLength = Integer.MAX_VALUE;
        String out = null;
        for (String word : words) {
            if (wordLength > word.length()) {
                int[] map1 = map.clone();
                for (int i = 0; i < word.length(); i++) {
                    map1[word.charAt(i) - 'a']--;
                }
                boolean isMatch = true;
                for (int i : map1) {
                    if (i > 0) {
                        isMatch = false;
                        break;
                    }
                }
                if (isMatch) {
                    wordLength = word.length();
                    out = word;
                }
            }
        }
        return out;
    }
}
// Revision