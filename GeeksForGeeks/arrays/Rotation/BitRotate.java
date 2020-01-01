package Rotation;

/**
 * BitRotate
 */
public class BitRotate {
    static final int INT_BITS = 32; 
    public static void main(String[] args) {
        int n = 16; 
    int d = 2; 
    System.out.print("Left Rotation of " + n + 
                          " by " + d + " is "); 
    System.out.print(leftRotate(n, d)); 
      
    System.out.print("\nRight Rotation of " + n + 
                             " by " + d + " is "); 
    System.out.print(rightRotate(n, d)); 
    }

    public static int leftRotate(int n, int d) {
        return (n << d) | (n >> (INT_BITS - d));
    }

    public static int rightRotate(int n, int d) {
        return (n >> d) | (n << (INT_BITS - d));
    }
}