// Largest Rectangle in Histogram
import java.util.*;
public class P84 {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        int areaWithTop = 0;
        int maxArea = 0;
        int tp = 0;

        int i = 0;
        int n = heights.length;
        while (i < n) {
            if (stack.empty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                tp = stack.pop();
                areaWithTop = heights[tp] * ((stack.empty()) ? i : i - stack.peek() - 1);
                if (maxArea < areaWithTop) {
                    maxArea = areaWithTop;
                }
            }
        }

        while (!stack.isEmpty()) {
            tp = stack.pop();
            areaWithTop = heights[tp] * ((stack.empty()) ? i : i - stack.peek() - 1);
            if (maxArea < areaWithTop) {
                maxArea = areaWithTop;
            }
        }
        return maxArea;
    }
}