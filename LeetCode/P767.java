//Reorganize String
import java.util.PriorityQueue;

public class P767 {
    public String reorganizeString(String S) {
        int[] freq = new int[26];
        for (char ch : S.toCharArray())
            freq[ch - 'a']++;
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> (freq[b - 'a'] - freq[a - 'a']));
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0)
                maxHeap.add((char) ('a' + i));
        }
        StringBuilder sb = new StringBuilder();
        char prev = 'A';
        for (int i = 0; i < S.length(); i++) {
            if (maxHeap.isEmpty())
                return "";
            char curr = maxHeap.poll();
            sb.append(curr);
            freq[curr - 'a']--;
            if (prev != 'A' && freq[prev - 'a'] > 0)
                maxHeap.add(prev);
            prev = curr;
        }
        return sb.toString();
    }
}