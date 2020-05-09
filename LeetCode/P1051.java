import java.util.Arrays;

//Height Checker
public class P1051 {
    public int heightChecker(int[] heights) {
        if (heights.length == 1)
            return 0;
        int copy[] = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            copy[i] = heights[i];
        }
        Arrays.sort(copy);
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            if (copy[i] != heights[i])
                count++;
        }
        return count;
    }
}