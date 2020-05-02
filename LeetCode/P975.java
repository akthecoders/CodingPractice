// Odd Even Jump
import java.util.*;
public class P975 {
    @SuppressWarnings("")
    public int oddEvenJumps(int[] A) {
        int goodIndex = 1;
        int arrLength = A.length;

        boolean[] higher = new boolean[arrLength];
        boolean[] lower = new boolean[arrLength];
        higher[arrLength - 1] = true;
        lower[arrLength - 1] = true;

        TreeMap<Integer, Integer> treeMap = new TreeMap<>();

        treeMap.put(A[arrLength - 1], arrLength - 1);
        for (int i = arrLength - 2; i >= 0; i--) {
            Map.Entry<Integer, Integer> higherKeyValuePair = treeMap.ceilingEntry(A[i]);
            Map.Entry<Integer, Integer> lowerKeyValuePair = treeMap.floorEntry(A[i]);

            if (higherKeyValuePair != null) {
                higher[i] = lower[(int) higherKeyValuePair.getValue()];
            }

            if (lowerKeyValuePair != null) {
                lower[i] = higher[(int) lowerKeyValuePair.getValue()];
            }

            if (higher[i]) {
                goodIndex++;
            }

            treeMap.put(A[i], i);
        }
        return goodIndex;
    }
}