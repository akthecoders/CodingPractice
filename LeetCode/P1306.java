// Jump Game III
import java.util.*;
public class P1306 {
    public static void main(String[] args) {
        int[] arr = {3, 0 ,2 , 1, 2};
        int start = 2;
        System.out.println(canReach(arr, start));
    }

    public static boolean canReach(int[] arr, int start) {
        boolean visited[] = new boolean[arr.length];
        Arrays.fill(visited, false);
        
        return dfs(visited, arr, start);
    }
    
    public static boolean dfs(boolean[] visited, int[] arr, int start) {
        visited[start] = true;
        if(arr[start] == 0) {
            return true;
        }
        if(isValid(start + arr[start], arr.length, visited) && dfs(visited, arr, start + arr[start])) {
            return true;
        }
        
        if(isValid(start - arr[start], arr.length, visited) && dfs(visited, arr, start - arr[start])) {
            return true;
        }
        
        return false;
    }
    
    public static boolean isValid(int num, int N, boolean visited[]) {
        if(num >= 0 && num < N && !visited[num]) {
            return true;
        }
        return false;
    }
}