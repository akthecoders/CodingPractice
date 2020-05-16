import java.util.ArrayList;
import java.util.List;

//Pascal's Triangle
public class P118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0)
            return result;
        ArrayList<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);
        if (numRows == 1)
            return result;
        ArrayList<Integer> second = new ArrayList<>();
        second.add(1);
        second.add(1);
        result.add(second);
        if (numRows == 2)
            return result;

        for (int i = 2; i < numRows; i++) {
            List<Integer> prev = result.get(i - 1);
            ArrayList<Integer> curr = new ArrayList<>();
            curr.add(1);
            for (int j = 1; j < prev.size(); j++) {
                int one = prev.get(j);
                int two = prev.get(j - 1);
                int sum = one + two;
                curr.add(sum);
            }
            curr.add(1);
            result.add(curr);
        }
        return result;

    }
}