package Rotation;

/**
 * MinMoveMakeStringsEqual
 */
public class MinMoveMakeStringsEqual {

    public static void main(String args[]) {
        String arr[] = { "xzzwo", "zwoxz", "zzwox", "xzzwo" };
        int n = arr.length;
        System.out.println(minimumMoves(arr, n)); 
    }

    private static int minimumMoves(String arr[], int n) {
        int minMoves = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) {
            String tmp = "";
            int currCount = 0;
            for(int j = 0; j < n; j++) {
                tmp = arr[j] + arr[j];
                int index =tmp.indexOf(arr[i]);
                if(index == arr[i].length()) {
                    return -1;
                }
                currCount += index;
            }
            minMoves = Math.min(currCount, minMoves);
        }
        return minMoves;
    }
}