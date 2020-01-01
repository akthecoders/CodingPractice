package Rotation;

/**
 * BlockRotation
 */
public class BlockRotation {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int blockSize = 3;
        int rotate = 1; // If positive rotate right else left rotate;
        rotateArr(arr, blockSize, rotate);
        for(int i = 0; i < arr.length; i++) 
            System.out.print(arr[i] + " ");
    }

    private static void rotateArr(int[] arr, int blockSize, int rotate) {
        for(int i = 0; i < arr.length; i = i + blockSize) {
            if(rotate >= 0) {
                rotateRight(arr, i, i + blockSize - 1);
            }   
            else {
                rotateLeft(arr, i, i + blockSize -1);
            }
        }
    }

    private static void rotateRight(int[] arr, int start, int end) {
        int temp = arr[end];
        for(int i = end; i > start; i--) {
            arr[i] = arr[i-1];
        }
        arr[start] = temp;
    }

    private static void rotateLeft(int[] arr, int start, int end) {
        int temp = arr[start];
        for(int i = start; i < end; i++) {
            arr[i] = arr[i+1];
        }
        arr[end] = temp;
    }
}