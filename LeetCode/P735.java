// Asteroid Collision
import java.util.*;
public class P735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            if (stack.isEmpty()) { // first check if the stack is empty or not
                stack.push(a);
            } else {
                while (!stack.isEmpty()) {
                    int peeker = stack.peek();
                    // if same direction: + and + both right, or -ve and -ve, both left
                    if (a > 0 && peeker > 0 || a < 0 && peeker < 0) {
                        stack.push(a);
                        break;
                    } else { // if the directions are opposite ... remember ... the items are coming from
                        // from the top in the stack ... imagine that TOP is coming from right
                        if (a > 0 && peeker < 0) {
                            stack.push(a);
                            break;
                        } else {
                            if (Math.abs(a) < Math.abs(peeker)) {
                                break;
                            } else if (Math.abs(a) == Math.abs(peeker)) {
                                stack.pop();
                                break;
                            } else {
                                stack.pop();
                                if (stack.isEmpty()) {
                                    stack.push(a);
                                    break;
                                }
                            }
                        }
                    }
                }
            }
        }
        int[] result = new int[stack.size()];
        int j = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[j] = stack.pop();
            j--;
        }
        return result;
    }
}