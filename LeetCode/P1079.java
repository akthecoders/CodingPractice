//Letter Tile Possibilities
public class P1079 {
    int result = 0;

    public int numTilePossibilities(String tiles) {
        int[] map = new int[26];
        for (char c : tiles.toCharArray()) {
            map[c - 'A']++;
        }
        helper(map);
        return result;
    }

    public void helper(int[] map) {

        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                result++;
                map[i]--;
                helper(map);
                map[i]++;
            }
        }
    }
}