// Network Delay Time

import java.util.*;
public class P743 {
    class Node {
        boolean visited;
        List<Path> paths = new ArrayList<>();
    }

    class Path {
        Node node;
        int distance;
        public Path(Node n, int distance) {
            this.node = n;
            this.distance = distance;
        }
    }

    public int networkDelayTime(int[][] times, int N, int K) {
        Node nodes[] = new Node[101];
        for(int i = 1; i <= N; i++) {
            nodes[i] = new Node();
        }

        for(int[] time: times) {
            nodes[time[0]].paths.add(new Path(nodes[time[1]], time[2]));
        }

        PriorityQueue<Path> q = new PriorityQueue<>((a, b) -> Integer.compare(a.distance, b.distance));

        q.add(new Path(nodes[K], 0));

        while(!q.isEmpty()) {
            Path path = q.poll();
            if(path.node.visited) {
                continue;
            }
            path.node.visited = true;
            if(--N == 0) {
                return path.distance;
            }
            for(Path p : path.node.paths) {
                q.add(new Path(p.node, path.distance + p.distance));
            }
        }
        return -1;
    }
}