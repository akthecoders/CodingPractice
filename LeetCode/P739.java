// Daily Temperatures
import java.util.*;
public class P739 {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> st = new Stack<>();
        int result[] = new int[T.length];
        int index = T.length - 1;
        while (index >= 0) {
            while (!st.isEmpty()) {
                if (T[st.peek()] > T[index]) {
                    result[index] = st.peek() - index;
                    break;
                } else {
                    st.pop();
                }
            }
            st.push(index);
            index--;
        }
        return result;
    }
}

// Revision