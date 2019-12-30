package Rotation;

/**
 * IsArraySortedRotated
 */
public class IsArraySortedRotated {

    public static void main(String args[]) {
        int[] inputArray = {1,2,3,4,5};
        int min = findMin(inputArray);
        if(min == inputArray.length || min == -1) {
            System.out.println("No");
        }
        else if(isIncreasing(inputArray, 0, min - 1) && isIncreasing(inputArray, min, inputArray.length - 1)) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }

    private static int findMin(int[] input) {
        for(int i = 0; i < input.length - 1; i++) {
            if(input[i] > input[i + 1]) {
                return i+1;
            }
        }
        return -1;
    }

    public static boolean isIncreasing(int[] input, int start, int end) {
        boolean result = true;
        for(int i = start; i < end; i++) {
            if(input[i] > input[i+1]) {
                result = false;
            }
        }
        return result;
    }
}