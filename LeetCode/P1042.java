import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class P1042 {
    public static void main(String[] args) {
        int N = 4;
        int[][] paths = {{1,2},{2,3},{3,4},{4,1},{1,3},{2,4}};

        Map<Integer, HashSet<Integer>> gMap = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            gMap.put(i, new HashSet<>());
        }

        for(int i = 0; i < paths.length; i++) {
            gMap.get(paths[i][0]).add(paths[i][1]);
            gMap.get(paths[i][1]).add(paths[i][0]);
        }

        int result[] = new int[N];

        for(int i = 1; i <= N; i++) {
            HashSet<Integer> flowerGarden = new HashSet<>();
            for(int neigh : gMap.get(i)) {
                flowerGarden.add(result[neigh-1]);
            }

            for(int flower = 1; flower <= 4 ; flower++) {
                if(!flowerGarden.contains(flower)) {
                    result[i - 1] = flower;
                }
            }
        }

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}