// Evaluate Division
import java.util.*;

public class P399 {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        
        HashMap<String, Integer> map = new HashMap<>();
        int index = 0;
        for(int i = 0; i < values.length; i++) {
            List<String> item = equations.get(i);
            if(!map.containsKey(item.get(0))) {
                map.put(item.get(0), index++);
            }
            if(!map.containsKey(item.get(1))) {
                map.put(item.get(1), index++);
            }
        }
        
        int n = map.size();
        double[][] graph = new double[n][n];
        
        for(int i = 0; i < values.length; i++) {
            List<String> item = equations.get(i);
            int a = map.get(item.get(0));
            int b = map.get(item.get(1));
            
            graph[a][b] = values[i];
            graph[b][a] = values[i] == 0 ? 0 : 1.0/values[i];
        }
        
        for(int i = 0; i < n; i++) {
            boolean[] visited = new boolean[n];
            visited[i] = true;
            graph[i][i] = 1.0;
            dfs(i, i, 1.0, visited, graph);
        }
        
        double[] result = new double[queries.size()];
        for(int i = 0; i < result.length; i++) {
            List<String> q = queries.get(i);
            String from = q.get(0), to = q.get(1);
            if(map.containsKey(from) && map.containsKey(to) && graph[map.get(from)][map.get(to)] != 0.0d) {
                result[i] = graph[map.get(from)][map.get(to)];
            }
            else {
                result[i] = -1;
            }
        }
        return result;
    }
    
    private void dfs(int start, int cur, double curValue, boolean[] visited, double[][] graph) {
        for(int i = 0; i < visited.length; i++) {
            if(visited[i]) continue;
            if(graph[cur][i] != 0.0d) {
                graph[start][i] = curValue * graph[cur][i];
                visited[i] = true;
                dfs(start, i, curValue * graph[cur][i], visited, graph);
            }
        }
    }
}