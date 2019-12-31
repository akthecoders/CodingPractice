package Rotation;

/**
 * Stringslicing
 */
public class Stringslicing {

    public static void main(String args[]) {
        String str = "GeeksforGeeks";
        int d = 2;
        System.out.println(rightRotation(str, d));
        System.out.println(leftRotation(str, d));
    }

    private static String rightRotation(String str, int d) {
        int len = str.length();
        return str.substring(len - d) + str.substring(0, len - d);
    }

    private static String leftRotation(String str, int d) {
        return str.substring(d) + str.substring(0, d);
    }
}