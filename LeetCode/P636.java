// Exclusive Time of Functions
import java.util.*;
public class P636 {
    class Log {
        int id;
        int time;
        boolean isStart;

        public Log(String str) {
            String[] arr = str.split(":");
            this.id = Integer.parseInt(arr[0]);
            this.time = Integer.parseInt(arr[2]);
            this.isStart = "start".equals(arr[1]);
        }
    }

    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Log> stack = new Stack<>();

        int res[] = new int[n];

        for (String str : logs) {
            Log log = new Log(str);
            if (log.isStart) {
                stack.push(log);
            } else {
                Log top = stack.pop();
                res[top.id] += log.time - top.time + 1;
                if (!stack.isEmpty()) {
                    Log prev = stack.peek();
                    res[prev.id] -= log.time - top.time + 1;
                }
            }
        }
        return res;
    }
}