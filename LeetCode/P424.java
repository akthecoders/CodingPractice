//Longest Repeating Character Replacement
public class P424 {
    public int characterReplacement(String s, int k) {
        int[] char_count = new int[26];

        int window_left = 0;
        int max_len = 0;
        int max_count = 0;

        for (int window_right = 0; window_right < s.length(); window_right++) {
            char_count[s.charAt(window_right) - 'A']++;
            int currCount = char_count[s.charAt(window_right) - 'A'];
            max_count = Math.max(max_count, currCount);

            while (window_right - window_left - max_count + 1 > k) {
                char_count[s.charAt(window_left) - 'A']--;
                window_left++;
            }

            max_len = Math.max(max_len, window_right - window_left + 1);
        }
        return max_len;
    }
}