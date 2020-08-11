//Flipping an Image
public class P832 {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A.length == 0)
            return A;

        for (int i[] : A) {
            reverse(i);
        }
        return A;
    }

    public void reverse(int[] input) {
        int start = 0;
        int end = input.length - 1;
        while (start < end) {
            int temp = input[start];
            input[start] = input[end] == 0 ? 1 : 0;
            input[end] = temp == 0 ? 1 : 0;
            start++;
            end--;
        }
        if (input.length % 2 == 1) {
            input[input.length / 2] = input[input.length / 2] == 0 ? 1 : 0;
        }
    }
}