import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

//Get Watched Videos by Your Friends
public class P1311 {
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        // BFS get video to frequency mappings among friends in level
        Map<String, Integer> videoToFreq = bfs(watchedVideos, friends, id, level);

        // Save into min heap
        PriorityQueue<Pair> minHeap = new PriorityQueue<>(
                (a, b) -> a.freq == b.freq ? a.video.compareTo(b.video) : a.freq - b.freq);
        for (Map.Entry<String, Integer> entry : videoToFreq.entrySet()) {
            minHeap.offer(new Pair(entry.getKey(), entry.getValue()));
        }

        // Get videos by freuencies increasingly
        List<String> resVideos = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            resVideos.add(minHeap.poll().video);
        }
        return resVideos;
    }

    private Map<String, Integer> bfs(List<List<String>> watchedVideos, int[][] graph, int id, int level) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(id);
        Set<Integer> visited = new HashSet<>();
        visited.add(id);
        int lvl = 0;
        Map<String, Integer> videoToFreq = new HashMap<>();

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int u = q.poll();
                if (lvl == level)
                    for (String video : watchedVideos.get(u))
                        videoToFreq.put(video, videoToFreq.getOrDefault(video, 0) + 1);
                for (int v : graph[u]) {
                    if (!visited.contains(v)) {
                        q.offer(v);
                        visited.add(v);
                    }
                }
            }
            lvl++;
            if (lvl > level) {
                break;
            }
        }
        return videoToFreq;
    }

    class Pair {
        String video;
        int freq;

        public Pair(String video, int freq) {
            this.video = video;
            this.freq = freq;
        }
    }
}