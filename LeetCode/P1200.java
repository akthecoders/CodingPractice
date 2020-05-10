import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//Minimum Absolute Difference
public class P1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(arr);
        int minDiff = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            int d = arr[i] - arr[i - 1];
            if (d < minDiff)
                minDiff = d;
        }
        for (int i = 1; i < arr.length; i++) {
            int d = arr[i] - arr[i - 1];
            if (d == minDiff) {
                List<Integer> t = new ArrayList<>();
                t.add(arr[i - 1]);
                t.add(arr[i]);
                list.add(t);
            }
        }
        return list;
    }
}