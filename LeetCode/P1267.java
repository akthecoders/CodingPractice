// Count Servers that Communicate

public class P1267 {
    public static void main(String[] args) {
        int[][] grid = {{1,0}, {0, 1}};
        P1267 p = new P1267();
        System.out.println(p.countServers(grid));
    }

    public int countServers(int[][] grid) {
        int[] r = new int[grid.length];
        int[] c = new int[grid[0].length];
        
        for (int i = 0 ; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                r[i] += grid[i][j]; 
                c[j] += grid[i][j];
            }
        }
        
        int sum = 0;
        for (int i = 0 ; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum += (r[i] > 1 || c[j] > 1) ? grid[i][j] : 0;
            }
        }
        return sum;
    }

}