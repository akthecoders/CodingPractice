import java.util.ArrayList;
import java.util.List;

//Gray Code
public class P89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            int val = i ^ (i >> 1);
            res.add(val);
        }
        return res;
    }
}