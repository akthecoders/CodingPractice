//Increasing Decreasing String
public class P1370 {
    public String sortString(String s) {
        StringBuilder charString = new StringBuilder(s.length());
        int[] charFrequency = new int[26];
        int charCount = 0;
        for (int i = 0; i < s.length(); i++) {
            charFrequency[s.charAt(i) - 'a']++;
        }

        while (charCount < s.length()) {
            for (int j = 0; j < 26; j++) {
                if (charFrequency[j] > 0) {
                    charString.append((char) (j + 'a'));
                    charFrequency[j] = charFrequency[j] - 1;
                    charCount++;
                }
            }
            for (int k = 25; k >= 0; k--) {
                if (charFrequency[k] > 0) {
                    charString.append((char) (k + 'a'));
                    charFrequency[k] = charFrequency[k] - 1;
                    charCount++;
                }
            }
        }
        return charString.toString();
    }
}