import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//Sequential Digits
public class P1291 {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> res = new ArrayList<>();
        for (int start = 1; start < 9; start++) {
            int num = start;
            int next = start + 1;
            while (num <= high && next <= 10) {
                if (num >= low) {
                    res.add(num);
                }
                num = num * 10 + next;
                next++;
            }
        }
        Collections.sort(res);
        return res;
    }
}