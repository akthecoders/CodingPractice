import java.util.HashMap;

//Element Appearing More Than 25% In Sorted Array
public class P1287 {
    public int findSpecialInteger(int[] arr) {
        if (arr.length == 1)
            return arr[0];

        HashMap<Integer, Integer> map = new HashMap<>();
        int required = (arr.length * 25) / 100;
        int maxF = 0;
        int maxNum = 0;
        for (int x : arr) {
            int freq = map.getOrDefault(x, 0);
            map.put(x, freq + 1);
            if (freq + 1 > required) {
                if (freq > maxF) {
                    maxF = freq;
                    maxNum = x;
                }
            }
        }
        return maxNum;
    }
}