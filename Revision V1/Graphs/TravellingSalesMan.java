package Graphs;

import java.util.HashSet;
import java.util.Set;

public class TravellingSalesMan {

    public static int solve(int[][] graph, int start, int curr, Set<Integer> set) {
        if(set.size() == 0) {
            return graph[curr][start];
        }
        int min = Integer.MAX_VALUE;
        for(Integer setData: set) {
            Set<Integer> newSet = new HashSet<>();
            newSet.addAll(set);
            newSet.remove(setData);
            min = Math.min(min, graph[curr][setData] + solve(graph, start, setData, newSet));
        }
        return min;
    }

    public static void main(String[] args) {
        int[][] g = { 
            {0, 16, 11, 6},
            {8, 0, 13, 16},
            {4, 7,  0,  9},
            {5, 12, 2,  0}
        };

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println(solve(g, 0, 0, set));

    }
}
