// First Unique Character In String
public class FirstUniqueCharacterInString {
    public int firstUniqChar(String s) {
        int letter[] = new int[26];
        int index = 0;
        for (Character x : s.toCharArray()) {
            letter[x - 'a']++;
        }

        for (Character x : s.toCharArray()) {
            if (letter[x - 'a'] == 1) {
                return index;
            }
            index++;
        }
        return -1;
    }
}