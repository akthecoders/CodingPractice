package Rearrangement;

/**
 * MaxCircularSuArraySum Given n numbers (both +ve and -ve), arranged in a
 * circle, fnd the maximum sum of consecutive number.
 */
public class MaxCircularSuArraySum {

    public static void main(String[] args) {
        int a[] = { 11, 10, -20, 5, -3, -5, 8, -13, 10 };
        System.out.println("Maximum circular sum is " + maxCircularSum(a));
    }

    public static int maxCircularSum(int[] arr) {
        int n = arr.length;
        int max_kadane = kadane(arr);

        int max_wrap = 0;
        for(int i = 0; i < n; i++) {
            max_wrap += arr[i];
            arr[i] = -arr[i];
        }
        max_wrap = max_wrap + kadane(arr);
        return (max_wrap > max_kadane) ? max_wrap : max_kadane;
    }

    public static int kadane(int[] arr) {
        int n = arr.length;
        int max_so_far = 0, max_ending_here = 0;
        for(int i = 0 ; i < n; i++) {
            max_ending_here = max_ending_here + arr[i];
            if(max_ending_here < 0) { max_ending_here = 0;}
            if(max_ending_here > max_so_far) {
                max_so_far = max_ending_here;
            }
        }

        return max_so_far;
    }
}