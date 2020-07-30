import java.util.ArrayList;
import java.util.List;

//Gray Code
public class P89 {
    public List<Integer> grayCode(int n) {
        List<Integer> code = new ArrayList<>();
        for (int i = 0; i < 1 << n; i++) {
            code.add(i ^ (i >> 1));
        }
        return code;
    }
}