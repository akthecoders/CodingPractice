import java.util.HashSet;
import java.util.Iterator;

//Intersection of Two Arrays
public class P349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums1) {
            set.add(x);
        }
        HashSet<Integer> list = new HashSet<>();
        for (int x : nums2) {
            if (set.contains(x))
                list.add(x);
        }

        int[] res = new int[list.size()];
        Iterator<Integer> value = list.iterator();
        int i = 0;
        while (value.hasNext()) {
            res[i++] = (int) value.next();
        }
        return res;
    }
}