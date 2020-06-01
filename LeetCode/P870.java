import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//Advantage Shuffle
public class P870 {
    public int[] advantageCount(int[] A, int[] B) {
        int[] sortedA = A.clone();
        Arrays.sort(sortedA);
        int[] sortedB = B.clone();
        Arrays.sort(sortedB);

        Map<Integer, Deque<Integer>> assigned = new HashMap<>();
        for (int b : B)
            assigned.put(b, new LinkedList<>());

        Deque<Integer> remaining = new LinkedList<>();

        int j = 0;
        for (int a : sortedA) {
            if (a > sortedB[j])
                assigned.get(sortedB[j++]).add(a);
            else
                remaining.add(a);
        }
        int[] ans = new int[B.length];
        for (int i = 0; i < B.length; i++) {
            if (assigned.get(B[i]).size() > 0)
                ans[i] = assigned.get(B[i]).pop();
            else
                ans[i] = remaining.pop();
        }
        return ans;
    }
}