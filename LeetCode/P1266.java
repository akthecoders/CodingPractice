// Minimum Time Visiting All Points
public class P1266 {
    public int minTimeToVisitAllPoints(int[][] points) {
        int totalTime = 0;
        int numRows = points[0].length;
        int numColl = points.length;

        for (int i = 0; i < numColl - 1; i++) {
            for (int x = 0; x < numRows - 1; x++) {
                totalTime += helper(points[i][x], points[i][x + 1], points[i + 1][x], points[i + 1][x + 1]);
            }
        }

        return totalTime;
    }

    public int helper(int x1, int y1, int x2, int y2) {
        int timeTaken = 0;

        if (Math.abs(x2 - x1) == Math.abs(y2 - y1)) {
            timeTaken = Math.abs(x2 - x1);
        } else if (Math.abs(x2 - x1) < Math.abs(y2 - y1)) {
            timeTaken = Math.abs(x2 - x1) + (Math.abs(y2 - y1) - Math.abs(x2 - x1));
        } else if (Math.abs(x2 - x1) > Math.abs(y2 - y1)) {
            timeTaken = Math.abs(y2 - y1) + (Math.abs(x2 - x1) - Math.abs(y2 - y1));
        }

        return timeTaken;
    }
}