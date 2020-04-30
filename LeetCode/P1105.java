// Filling Bookcase Shelves
public class P1105 {
    public int minHeightShelves(int[][] books, int shelf_width) {
        if (books == null || books.length == 0)
            return 0;
        int N = books.length;

        int dp[] = new int[N + 1];

        for (int j = N - 1; j >= 0; j--) {
            int minHeight = Integer.MAX_VALUE;
            int currHeight = 0;
            int currentThickness = 0;
            for (int k = j + 1; k <= N; k++) {
                currHeight = Math.max(currHeight, books[k - 1][1]);
                currentThickness += books[k - 1][0];
                if (currentThickness > shelf_width)
                    break;

                minHeight = Math.min(minHeight, currHeight + dp[k]);
            }
            dp[j] = minHeight;
        }
        return dp[0];
    }
}