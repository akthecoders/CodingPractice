//Find the Difference
public class P389 {
    public char findTheDifference(String s, String t) {
        int alpha[] = new int[26];

        for (char c : s.toCharArray()) {
            alpha[c - 'a']++;
        }

        for (char c : t.toCharArray()) {
            alpha[c - 'a']--;
        }

        for (int i = 0; i < 26; i++)
            if (alpha[i] != 0)
                return (char) (i + 'a');
        return '\0';
    }
}