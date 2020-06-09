import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//Distant Barcodes
public class P1054 {
    public int[] rearrangeBarcodes(int[] barcodes) {
        HashMap<Integer, Integer> fM = new HashMap<>();
        for (int x : barcodes) {
            fM.put(x, fM.getOrDefault(x, 0) + 1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> pQ = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pQ.addAll(fM.entrySet());
        int idx = 0;
        Arrays.fill(barcodes, -1);
        while (!pQ.isEmpty()) {
            Map.Entry<Integer, Integer> m = pQ.poll();
            int key = (int) m.getKey();
            int val = (int) m.getValue();
            int j = val;
            while (j > 0) {
                if (barcodes[idx % barcodes.length] == -1) {
                    barcodes[idx % barcodes.length] = key;
                    idx = idx + 2;
                    j--;
                } else {
                    idx++;
                }
            }
        }
        return barcodes;
    }
}