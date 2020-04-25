// Find the City With the Smallest Number of Neighbors at a Threshold Distance
public class P1334 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int graph[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.MAX_VALUE;
                graph[i][i] = 1;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][i] = 1;
            }
        }
        for (int i = 0; i < edges.length; i++) {
            graph[edges[i][0]][edges[i][1]] = edges[i][2];
            graph[edges[i][1]][edges[i][0]] = edges[i][2];
        }

        fillDistances(graph, n);

        int mincount = n, cityId = -1;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                count += ((i != j && graph[i][j] <= distanceThreshold) ? 1 : 0);
            }
            if (count <= mincount) {
                cityId = i;
                mincount = count;
            }
        }
        return cityId;
    }

    public void fillDistances(int[][] graph, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (graph[j][i] != Integer.MAX_VALUE && graph[i][k] != Integer.MAX_VALUE
                            && graph[j][i] + graph[i][k] < graph[j][k]) {
                        graph[j][k] = graph[j][i] + graph[i][k];
                    }
                }
            }
        }
    }
}