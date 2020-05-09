import java.util.ArrayList;
import java.util.List;

//Path In Zigzag Labelled Binary Tree
public class P1104 {
    public List<Integer> pathInZigZagTree(int label) {
        if (label == 1) {
            List<Integer> res = new ArrayList<Integer>();
            res.add(1);
            return res;
        }
        List<Integer> res = new ArrayList<Integer>();
        res.addAll(pathInZigZagTree(parent(label)));
        res.add(label);
        return res;
    }

    int parent(int x) {
        int e = exponent(x);
        return e - 1 - ((x - e) / 2);

    }

    int exponent(int x) {
        if (x == 1)
            return 1;
        return exponent((x - x % 2) / 2) << 1;
    }
}