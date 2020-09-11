import java.util.Stack;

//Maximal Rectangle
public class P85 {
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int max = 0;
        int heights[] = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '0') {
                    heights[j] = 0;
                } else {
                    heights[j]++;
                }
            }
            max = Math.max(max, largestRectangle(heights));
        }
        return max;
    }

    public int largestRectangle(int[] heights) {
        if (heights.length == 0)
            return 0;
        if (heights.length == 1)
            return heights[0];

        int max = 0;
        Stack<Integer> stack = new Stack<>();
        stack.add(0);

        for (int i = 0; i < heights.length; i++) {
            int curr = heights[i];
            if (curr >= heights[stack.peek()]) {
                stack.add(i);
            } else {
                while (!stack.isEmpty() && curr < heights[stack.peek()]) {
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
