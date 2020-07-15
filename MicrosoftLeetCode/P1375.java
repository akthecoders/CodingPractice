//Bulb Switcher III
public class P1375 {
    public int numTimesAllBlue(int[] light) {
        int rightMax = -1;
        int count = 0;
        for (int i = 0; i < light.length; i++) {
            rightMax = Math.max(light[i], rightMax);
            if (rightMax == i + 1)
                count++;
        }
        return count;
    }
}