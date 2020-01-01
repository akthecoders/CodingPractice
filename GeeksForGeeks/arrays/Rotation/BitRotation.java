package Rotation;

/**
 * BitRotation
 */
public class BitRotation {

    public static void main(String[] args) {
        long x = 122; 
        long y = 2147483678L; 
  
        if (isRotation(x, y) == false) { 
            System.out.println("Yes"); 
        } else { 
            System.out.println("No"); 
        } 
    }

    private static boolean isRotation(long x, long y) {
        long x64 = x | (x << 32);
        while(x64 >= y) {
            if(x64 == y) {
                return true;
            }

            x64 = x64 >> 1;
        }
        return false;
    }
}