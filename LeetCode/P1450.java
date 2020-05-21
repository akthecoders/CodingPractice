//Number of Students Doing Homework at a Given Time
public class P1450 {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int result = 0;
        for (int i = 0; i < startTime.length; i++) {
            int start = startTime[i];
            int end = endTime[i];
            if (start <= queryTime && end >= queryTime) {
                result++;
            }
        }
        return result;
    }
}