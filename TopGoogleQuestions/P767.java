import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Reorganize String
public class P767 {
    public String reorganizeString(String S) {
        PriorityQueue<Map.Entry<Character, Integer>> queue = new PriorityQueue<>((entry1, entry2) -> {
            return entry2.getValue() - entry1.getValue();
        });

        char[] arr = new char[S.length()];
        Map<Character, Integer> map = new HashMap<>();
        for (char c : S.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        map.entrySet().forEach((entry) -> {
            queue.offer(entry);
        });

        // First Entry
        Map.Entry<Character, Integer> entry = queue.poll();
        int count = entry.getValue();
        char c = entry.getKey();
        int i = 0;
        for (; i < arr.length && count > 0; i += 2, count--) {
            arr[i] = c;
        }
        if (count > 0)
            return "";

        // Remaining Odd Positions
        int carry = 0;
        char carryCharacter = ' ';
        while (!queue.isEmpty() && i < arr.length) {
            entry = queue.poll();
            count = entry.getValue();
            for (; i < arr.length && count > 0; i += 2, count--) {
                arr[i] = entry.getKey();
            }
            if (count > 0) {
                carry = count;
                carryCharacter = entry.getKey();
            }
        }

        i = 1;
        while (i < arr.length && carry > 0) {
            arr[i] = carryCharacter;
            i += 2;
            carry--;
        }

        while (!queue.isEmpty() && i < arr.length) {
            entry = queue.poll();
            count = entry.getValue();
            for (; count > 0 && i < arr.length; i += 2, count--) {
                arr[i] = entry.getKey();
            }
        }
        return new String(arr);

    }
}
