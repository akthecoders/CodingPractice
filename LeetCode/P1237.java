import java.util.ArrayList;
import java.util.List;

//Find Positive Integer Solution for a Given Equation
public class P1237 {
    class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y) {
            return 1;
        }
    };

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        List<Integer> temp;

        for (int i = 1; i <= z; i++) {
            for (int j = 1; j <= z; j++) {
                temp = new ArrayList<Integer>();

                if (customfunction.f(i, j) == z) {
                    System.out.println(i + " " + j);
                    temp.add(i);
                    temp.add(j);
                    list.add(temp);
                }
            }
        }

        return list;
    }
}