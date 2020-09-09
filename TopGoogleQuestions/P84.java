import java.util.Stack;

// Largest Rectangle in Histogram
public class P84 {
    public int largestRectangleArea(int[] heights) {
        if (heights.length == 0)
            return 0;
        if (heights.length == 1)
            return heights[0];

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            int height = heights[i];

            if (height >= heights[stack.peek()]) {
                stack.push(i);
            } else {
                while (!stack.isEmpty() && height < heights[stack.peek()]) {
                    int temp = heights[stack.pop()];

                    if (stack.isEmpty()) {
                        max = Math.max(max, temp * i);
                    } else {
                        max = Math.max(max, temp * (i - stack.peek() - 1));
                    }
                }
                stack.add(i);
            }
        }

        if (!stack.isEmpty()) {
            int i = heights.length;
            while (!stack.isEmpty()) {
                int temp = heights[stack.pop()];
                if (stack.isEmpty()) {
                    max = Math.max(max, temp * i);
                } else {
                    max = Math.max(max, temp * (i - stack.peek() - 1));
                }
            }
        }
        return max;
    }
}
