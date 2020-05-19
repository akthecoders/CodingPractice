import java.util.LinkedList;

//Queries on a Permutation With Key
public class P1409 {
    public int[] processQueries(int[] queries, int m) {
        LinkedList<Integer> p = new LinkedList<>();
        for (int i = 1; i <= m; i++) {
            p.add(i);
        }
        for (int i = 0; i < queries.length; i++) {
            int index = p.indexOf(queries[i]);
            p.remove((Integer) queries[i]);
            p.addFirst(queries[i]);
            queries[i] = index;
        }
        return queries;

    }
}