import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Reduce Array Size to The Half
public class P1338 {
    public int minSetSize(int[] arr) {
        if (arr == null || arr.length == 0)
            return 0;
        int len = arr.length;
        int target = len / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            int freq = map.getOrDefault(i, 0) + 1;
            map.put(i, freq);
        }
        PriorityQueue<Candidate> maxHeap = new PriorityQueue<>((o1, o2) -> Integer.compare(o2.frequency, o1.frequency));
        for (int key : map.keySet()) {
            maxHeap.add(new Candidate(key, map.get(key)));
        }
        int result = 0;
        while (len > target) {
            Candidate c = maxHeap.remove();
            len -= c.frequency;
            result++;
        }

        return result;
    }

    private static class Candidate {
        private final int value;
        private final int frequency;

        public Candidate(int v, int f) {
            this.value = v;
            this.frequency = f;
            System.out.println("value" + this.value);
        }
    }
}