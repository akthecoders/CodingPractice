// Remove Duplicate Letters
public class P316 {
    public String removeDuplicateLetters(String s) {
        StringBuilder sb = new StringBuilder();
        int[] count = new int[26];
        boolean visited[] = new boolean[26];
        char[] chs = s.toCharArray();
        for (Character c : chs) {
            count[c - 'a']++;
        }

        for (Character c : chs) {
            count[c - 'a']--;
            if (visited[c - 'a'])
                continue;

            while (sb.length() > 0 && c < sb.charAt(sb.length() - 1) && count[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                visited[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(c);
            visited[c - 'a'] = true;
        }
        return sb.toString();
    }
}