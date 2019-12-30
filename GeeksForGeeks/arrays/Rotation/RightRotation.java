package Rotation;

/**
 * RightRotation
 */
public class RightRotation {
    public static void main(String[] args) {
        int input[] = {1, 2, 3, 4, 5, 6};
        int N = 6;
        int rotate = 2;

        rightRotate(input, rotate, N);
        for (int i : input) {
            System.out.print(i + " ");
        }
    }

    private static void rightRotate(int[] input, int rotate, int N) {
        if(rotate > input.length){
            rotate = rotate %input.length;
        }
     
        //length of first part
        int a = input.length - rotate; 
     
        reverse(input, 0, a-1);
        reverse(input, a, input.length-1);
        reverse(input, 0, input.length-1);
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