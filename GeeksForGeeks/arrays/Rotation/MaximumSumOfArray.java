package Rotation;

/**
 * MaximumSumOfArray next_val = curr_val - (cum_sum - arr[i-1]) + arr[i-1] *
 * (n-1);
 * 
 * next_val = Value of &Sum;i*arr[i] after one rotation. curr_val = Current
 * value of &Sum;i*arr[i] cum_sum = Sum of all array elements, i.e.,
 * &Sum;arr[i].
 * 
 * Lets take example {1, 2, 3}. Current value is 1*0+2*1+3*2 = 8. Shifting it by
 * one will make it {2, 3, 1} and next value will be 8 - (6 - 1) + 1*2 = 5 which
 * is same as 2*0 + 3*1 + 1*2
 */
public class MaximumSumOfArray {

    public static void main(String[] args) {
        int arr[] = { 8, 3, 1, 2 };
        int n = arr.length;
        System.out.println(maxSum(arr, n));
    }

    private static int maxSum(int arr[], int n) {
        int cum_sum = 0;
        for (int i = 0; i < n; i++)
            cum_sum += arr[i];
        int curr_val = 0;
        for (int i = 0; i < n; i++)
            curr_val += i * arr[i];
        int res = curr_val; 
        for (int i = 1; i < n; i++) {
            int next_val = curr_val - (cum_sum - arr[i - 1]) + arr[i - 1] * (n - 1);
            curr_val = next_val;
            res = Math.max(res, next_val);
        }
        return res;
    }
}