import java.util.*;

public class ConstructBinaryPalindrome {
    public static void main(String[] args) {
        int n = 10, k = 4;
        printBinaryPalindrome(n , k);
    }

    @SuppressWarnings("unchecked")
    public static void printBinaryPalindrome(int n ,int k) {
        int[] arr = new int[n];
        int[] ans = new int[n];

        Vector<Integer>[] connectChars = new Vector[k];
        for(int i = 0; i < k; i++) {
            connectChars[i] = new Vector<Integer>();
        }

        for(int i = 0; i < n; i++) {
            arr[i] = i % k;
        }

        for(int i = 0; i < n/2; i++) {
            connectChars[arr[i]].add(arr[n-i-1]);
            connectChars[arr[n-i-1]].add(arr[i]);
        }

        dfs(0, ans, connectChars);

        for (int i = 0; i < n; i++) 
        System.out.print(ans[arr[i]]);
    }

    public static void dfs(int parent, int[] marked, Vector<Integer>[] graph) {
        marked[parent] = 1;

        for(int i = 0; i < graph[parent].size(); i++) {
            int n = graph[parent].get(i);
            if(marked[n] != 1) {
                dfs(n, marked, graph);
            }
        }
    }
}