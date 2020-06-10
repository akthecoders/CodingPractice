import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

//Find K Pairs with Smallest Sums
public class P373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums1 == null || nums1.length == 0 || nums2 == null || nums2.length == 0)
            return res;
        PriorityQueue<Integer[]> pQ = new PriorityQueue<>((a, b) -> a[0] + a[1] - (b[0] + b[1]));
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pQ.offer(new Integer[] { nums1[i], nums2[j] });
            }
        }
        for (int i = 0; i < k; i++) {
            if (!pQ.isEmpty()) {
                Integer[] arr = pQ.poll();
                List<Integer> list = new ArrayList<>(Arrays.asList(arr));
                res.add(list);
            }
        }
        return res;
    }
}