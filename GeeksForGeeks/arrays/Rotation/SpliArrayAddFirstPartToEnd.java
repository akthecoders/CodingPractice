package Rotation;

/**
 * SpliArrayAddFirstPartToEnd
 */
public class SpliArrayAddFirstPartToEnd {

    public static void main(String args[]) {
        int input[] = {12, 10, 5, 6, 52, 36};
        int N = 6;
        int splitAt = 2;

        splitArray(input, splitAt, N);
        for (int i : input) {
            System.out.print(i + " ");
        }
    }

    private static void splitArray(int[] input, int splitIndex, int N) {
        reverse(input, 0, N - 1);
        reverse(input, 0, N - splitIndex - 1);
        reverse(input, N - splitIndex, N - 1);
    }

    private static void reverse(int[] input, int start, int end) {
        while(end > start) {
            int temp = input[start];
            input[start] = input[end];
            input[end] = temp;
            start++;
            end--;
        }
    }
}