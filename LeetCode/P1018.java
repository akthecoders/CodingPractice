import java.util.ArrayList;
import java.util.List;
// Binary Prefix Divisible By 5
public class P1018 {
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> l = new ArrayList<Boolean>();
        int temp = 0;
        for (int i = 0; i < A.length; i++) {
            temp = ((temp * 2) + A[i]) % 5;
            if (temp == 0) {
                l.add(true);
            } else {
                l.add(false);
            }
        }
        return l;
    }
}