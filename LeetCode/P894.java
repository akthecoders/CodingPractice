// All Possible Full Binary Trees
import java.util.*;

public class P894 {
    Map<Integer, List<TreeNode>> map = new HashMap<>();

    public List<TreeNode> allPossibleFBT(int N) {
        if (map.containsKey(N)) {
            return map.get(N);
        }

        List<TreeNode> list = new ArrayList<>();

        if (N == 0 || N % 2 == 0) {
            return list;
        } else if (N == 1) {
            list.add(new TreeNode(0));
            map.put(1, list);
            return list;
        } else {
            for (int i = 1; i < N; i += 2) {
                List<TreeNode> left = allPossibleFBT(i);
                List<TreeNode> right = allPossibleFBT(N - i - 1);

                for (int j = 0; j < left.size(); j++) {
                    for (int k = 0; k < right.size(); k++) {
                        TreeNode root = new TreeNode(0);
                        root.left = left.get(j);
                        root.right = right.get(k);
                        list.add(root);
                    }
                }
            }
        }
        map.put(N, list);
        return list;
    }
}