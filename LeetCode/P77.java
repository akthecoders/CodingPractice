//Combinations
import java.util.ArrayList;
import java.util.List;

public class P77 {
    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        for(int i = 1; i <= n; i++) {
            visited[i] = true;
            list.add(i);
            helper(n, k, 1, visited, list);
            list.remove(list.size() - 1);
        }
        return res;
    }
    
    public void helper(int n, int k, int curr, boolean[] visited, List<Integer> list) {
       
        if(k <= list.size()) {
            List<Integer> copy = new ArrayList<>();
            copy.addAll(list);
            res.add(copy);
            return;
        }
        
        visited[curr] = true;
        
        for(int i = curr; i <= n; i++) {
            if(!visited[i]) {
                list.add(i);
                helper(n, k, i, visited, list);
                list.remove(list.size() - 1);
            }
        }        
        
        visited[curr] = false;
    }    
}