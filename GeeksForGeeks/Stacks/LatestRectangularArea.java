/**
 * LatestRectangularArea
 */
import java.util.Stack;
public class LatestRectangularArea {

  public static void main(String[] args) {
      int hist[] = { 6, 2, 5, 4, 5, 1, 6 }; 
      System.out.println("Maximum area is " + getMaxArea(hist, hist.length)); 
  }

  public static int getMaxArea(int[] hist, int n) {
    Stack<Integer> stack = new Stack<>();
    int maxArea = 0;
    int tp = 0;
    int areaWithTop;
    int i = 0;
    while(i < n) {
      if(stack.isEmpty() || hist[stack.peek()] <= hist[i]) {
        stack.push(i++);
      }
      else {
        tp = stack.peek();
        stack.pop();
        areaWithTop = hist[tp] * (stack.empty() ? i : i - stack.peek() -1);

        if(maxArea < areaWithTop) {
          maxArea = areaWithTop;
        }
      }
    }
    while(!stack.empty()) {
      tp = stack.peek();
      stack.pop();

      areaWithTop = hist[tp] * (stack.empty() ? i : i - stack.peek() -1);
      if(maxArea < areaWithTop) {
        maxArea = areaWithTop;
      }
    }
    return maxArea;
  }
}