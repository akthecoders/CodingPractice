import java.util.HashMap;

/**
 * MaxDistance
 */
public class MaxDistance {

    public static void main(String[] args) {
        int[] arr = { 3, 2, 1, 2, 1, 4, 5, 8, 6, 7, 4, 2 };
        int n = arr.length;
        System.out.println(maxDistance(arr, n));
    }

    public static int maxDistance(int[] arr, int n) {
        int result = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            if(!map.containsKey(arr[i])) {
                map.put(arr[i], i);
            }
            else {
                result = Math.max(result, Math.abs(i - map.get(arr[i])));
            }
        }
        return result;
    }
}