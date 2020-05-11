import java.util.ArrayList;
import java.util.HashMap;

//Sum of Distances in Tree
public class P834 {
    HashMap<Integer, int[]> dp = new HashMap<Integer, int[]>();
    @SuppressWarnings("unchecked")
    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        if (N <= 1)
            return new int[] { 0 };
        ArrayList<Integer>[] tree = new ArrayList[N];
        for (int i = 0; i < N - 1; i++) {
            int n1 = edges[i][0];
            int n2 = edges[i][1];
            if (tree[n1] == null)
                tree[n1] = new ArrayList<Integer>();
            tree[n1].add(n2);
            if (tree[n2] == null)
                tree[n2] = new ArrayList<Integer>();
            tree[n2].add(n1);
        }
        int result[] = new int[N];
        for (int i = 0; i < N; i++) {
            for (int nn : tree[i]) {
                result[i] += dfs(nn, i, tree)[0];
            }
        }
        return result;
    }

    public int[] dfs(int start, int prev, ArrayList<Integer>[] tree) {
        int encode = (prev << 15) + start;
        int[] res = dp.getOrDefault(encode, null);
        if (res != null)
            return res;
        res = new int[2];
        for (int nn : tree[start]) {
            if (prev != nn) {
                int[] r = dfs(nn, start, tree);
                res[0] += r[0];
                res[1] += r[1];
            }
        }
        res[1] += 1;
        res[0] += res[1];
        dp.put(encode, res);
        return res;
    }
}