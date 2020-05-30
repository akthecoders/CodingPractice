// Container with most water
public class P11 {
    public int maxArea(int[] height) {
        if (height.length == 0)
            return 0;
        if (height.length == 1)
            return 0;
        if (height.length == 2)
            return Math.min(height[0], height[1]);

        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            maxArea = Math.max(maxArea, h * w);

            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;
    }
}