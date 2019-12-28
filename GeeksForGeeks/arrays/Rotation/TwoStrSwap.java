package Rotation;

import java.util.Scanner;

/**
 * TwoStrSwap
 */
public class TwoStrSwap {

    public static void main(String args[]) { 
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine();
        String str2 = scan.nextLine();
        int d = scan.nextInt();
        System.out.println(canStringsBeSame(str1, str2, d));
        scan.close();
    }

    private static String canStringsBeSame(String str1, String str2, int d) {
        String leftStr1 = str1;
        for(int i =0; i < d; i++) {
            leftStr1 = leftRotate(leftStr1);
        }
        if(leftStr1.equals(str2)) {
            return "YES";
        }
        String rightStr1 = str1;
        for(int i =0; i < d; i++) {
            rightStr1 = rightRotate(rightStr1);
        }
        if(rightStr1.equals(str2)) {
            return "YES";
        }
        return "NO";   
    }

    private static String leftRotate(String str) {
        return str.substring(1, str.length()) + str.substring(0 , 1);
    }
    
    private static String rightRotate(String str) {
        return str.substring(str.length() - 1) + str.substring(0, str.length() - 1);
    }
}