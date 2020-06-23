//Permutation Sequence
public class P60 {
    String output;
    int count = 0;

    public String getPermutation(int n, int k) {
        boolean visited[] = new boolean[n + 1];
        helper("", visited, n, k);
        return output;
    }

    public boolean helper(String curr, boolean visited[], int n, int k) {
        if (curr.length() == n) {
            count++;
            if (count == k) {
                output = curr;
                return true;
            }
            return false;
        }

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                if (helper(curr + i, visited, n, k)) {
                    return true;
                }
                visited[i] = false;
            }
        }
        return false;
    }
}