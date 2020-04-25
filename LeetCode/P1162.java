// As Far from Land as Possible

import java.util.*;
public class P1162 {
    public int maxDistance(int[][] grid) {
        int N = grid.length;
        Queue<int []> q = new LinkedList<>();
        
        for(int i = 0 ; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(grid[i][j] == 1) {
                    q.add(new int[]{i, j});
                }
            }
        }
         if(q.size() == 0 || q.size() == N*N){
            return -1;
        }
        int dis = 0, out = 0;
        
         while(!q.isEmpty()) {
             for(int i = 0; i < q.size(); i++) {
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                 
                out = Math.max(out, grid[r][c]);          
                dis = grid[r][c] + 1;
                 
                 if(r - 1 >= 0 && grid[r - 1][c] == 0){ 
                    grid[r - 1][c] = dis;
                    q.add(new int[]{r - 1,c});
                }
                if(r + 1 < N && grid[r + 1][c] == 0){
                    grid[r + 1][c] = dis;
                    q.add(new int[]{r + 1,c});
                }
                if(c - 1 >= 0 && grid[r][c - 1] == 0){
                    grid[r][c - 1] = dis;
                    q.add(new int[]{r,c - 1});
                }
                if(c + 1 < N && grid[r][c + 1] == 0){
                    grid[r][c + 1] = dis;
                    q.add(new int[]{r,c + 1});
                }
             }
         }
        return out - 1;
    }
}