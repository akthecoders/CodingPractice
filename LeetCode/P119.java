import java.util.ArrayList;
import java.util.List;

//Pascal's Triangle II
public class P119 {
    public List<Integer> getRow(int rowIndex) {
        ArrayList<Integer> prev = new ArrayList<>();
        if (rowIndex == 0) {
            prev.add(1);
            return prev;
        }
        prev.add(1);
        prev.add(1);
        if (rowIndex == 1)
            return prev;

        for (int i = 2; i <= rowIndex; i++) {
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < prev.size(); j++) {
                int one = prev.get(j);
                int two = prev.get(j - 1);
                int sum = one + two;
                curr.add(sum);
            }
            curr.add(1);
            prev = curr;
        }
        return prev;
    }
}