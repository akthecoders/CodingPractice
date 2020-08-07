//Valid Anagram
public class P242 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        int[] letters = new int[26];

        for (char c : s.toCharArray()) {
            letters[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            letters[c - 'a']--;
        }

        for (int x : letters) {
            if (x > 0)
                return false;
        }
        return true;

    }
}