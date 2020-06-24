import java.util.ArrayList;
import java.util.List;

//Build an Array With Stack Operations
public class P1441 {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        int index = 0;
        for (int i = 1; i <= n; i++) {
            result.add("Push");
            if (i != target[index]) {
                result.add("Pop");
                continue;
            }
            index++;
            if (index == target.length) {
                break;
            }
        }
        return result;
    }
}