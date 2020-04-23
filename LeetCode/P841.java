// Room Key Lock
import java.util.*;

public class P841 {
    public static void main(String[] args) {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(new ArrayList<>());
        rooms.add(new ArrayList<>());
        rooms.add(new ArrayList<>());
        rooms.add(new ArrayList<>());

        rooms.get(0).add(1);
        rooms.get(1).add(2);
        rooms.get(2).add(3);

        System.out.println(canVisitAllRooms(rooms));
    }

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean visited[] = new boolean[rooms.size()];
        for(int i = 0; i < rooms.size(); i++) {
            if(i > 0 && !visited[i]) {
                return false;
            }
            dfs(rooms, i, visited);
        }
        return true;
    }
    
    public static void dfs(List<List<Integer>> rooms, int u, boolean visited[]) {
        visited[u] = true;
        Iterator<Integer> itr = rooms.get(u).iterator();
        while(itr.hasNext()) {
            Integer v = itr.next();
            if(!visited[v]) {
                dfs(rooms, v, visited);
            }
        }
    }
}