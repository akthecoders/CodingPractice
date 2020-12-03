import java.util.LinkedList;
import java.util.Queue;

public class Turnstile {
    public static void main(String[] args) {
        
    }

    public static int[] getTimes(int[] times, int[] directions) {
        Queue<Integer> entry = new LinkedList<>();
        Queue<Integer> exit = new LinkedList<>();

        for(int i = 0; i < directions.length; i++) {
            int dir = directions[i];
            if(dir == 0) entry.offer(i);
            else exit.offer(i);
        }

        int prev = -1;
        int time = 0;
        while(!entry.isEmpty() && !exit.isEmpty()) {
            int entryTime = Math.max(time, times[entry.peek()]);
            int exitTime = Math.max(time, times[exit.peek()]);

            if(Math.min(entryTime, exitTime) > time) {
                time = Math.min(entryTime, exitTime);
                prev = -1;
            }

            if(entryTime == exitTime) {
                if(prev == -1 || prev == 1) {
                    directions[exit.remove()] = time;
                    prev = 1;
                }
                else {
                    directions[entry.remove()] = time;
                    prev = 0;
                }
            }
            else if(entryTime < exitTime) {
                directions[entry.remove()] = time;
                prev = 0;
            }
            else if(entryTime > exitTime) {
                directions[exit.remove()] = time;
                prev = 1;
            }
            time++;
        }

        while(!entry.isEmpty()) {
            int curTime = Math.max(time, times[entry.peek()]);
            directions[curTime] = time;
            time++;
        }
        while(!exit.isEmpty()) {
            int curTime = Math.max(time, times[exit.peek()]);
            directions[curTime] = time;
            time++;
        }
        return directions;
    }
}
