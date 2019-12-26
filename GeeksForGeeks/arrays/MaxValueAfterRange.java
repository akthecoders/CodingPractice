import java.util.Arrays;
import java.util.Scanner;

/**
 * MaxValueAfterRange
 */
public class MaxValueAfterRange {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int noOfElements = scan.nextInt();
        int mValue = scan.nextInt();
        int[] intAry = new int[noOfElements];
        for(int j = 0; j < mValue; j++) {
            int start = scan.nextInt();
            int end = scan.nextInt();
            int incBy = scan.nextInt();
            for(int i = start; i <= end; i++) {
                intAry[i] = intAry[i] + incBy;
            }
        }
        Arrays.sort(intAry);
        int max=intAry[intAry.length-1];
        System.out.println(max);
        scan.close();
    }
}