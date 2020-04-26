// K- Similar Strings

public class P854 {
    public int kSimilarity(String A, String B) {
        char[] a = A.toCharArray();
        char[] b = B.toCharArray();

        return dfs(0, a, b);
    }

    public int dfs(int start, char[] a, char[] b) {
        for (int i = start; i < a.length - 1; i++) {
            if (a[i] == b[i]) {
                continue;
            }
            int min = Integer.MAX_VALUE;

            for (int j = i + 1; j < a.length; j++) {
                if (a[j] != b[j] && a[j] == b[i]) {
                    swap(a, i, j);
                    min = Math.min(min, dfs(i + 1, a, b) + 1);
                    swap(a, i, j);

                    if (a[i] == b[j]) {
                        break;
                    }
                }
            }
            return min;
        }
        return 0;
    }

    void swap(char[] arr, int a, int b) {
        char temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}