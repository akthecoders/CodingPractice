package Rotation;

import java.util.HashMap;
import java.util.Map;

/**
 * OneOccurenceOfElement
 */
public class OneOccurenceOfElement {

    public static void main(String args[]) {
        int[] arr = { 7, 7, 8, 8, 9, 1, 1, 4, 2, 2 };
        int n = arr.length;
        occurredOnceHashMap(arr, n); 
    }

    private static void occurredOnceHashMap(int[] input, int n) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) {
            if(map.containsKey(input[i])) {
                map.put(input[i], map.get(input[i]) + 1);
            }
            else {
                map.put(input[i], 1);
            }
        }

        for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (Integer.parseInt(String.valueOf(entry.getValue())) == 1)
                System.out.print(entry.getKey() + " "); 
        }
    }
}