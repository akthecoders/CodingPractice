package Rotation;

import java.util.Scanner;

/**
 * NoLargeInAllRotation Given an integer x, the task is to find if every k-cycle
 * shift on the element produces a number greater than or equal to the same
 * element. A k-cyclic shift of an integer x is a function that removes the last
 * k digits of x and inserts them in its beginning. For example, the k-cyclic
 * shifts of 123 are 312 for k=1 and 231 for k=2. Print Yes if the given
 * condition is satisfied else print No.
 */
public class NoLargeInAllRotation {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        System.out.println(areAllRotationsGreater(number));
        scan.close();
    }

    private static String areAllRotationsGreater(int number) {
        int digits = numberOfDigits(number);
        int num = number;
        boolean result = true;
        for(int i = 0; i < digits - 1; i++) {
           num = rotate(num, digits);
           if(num < number) {
                result = false;
                break;
           }
        }
        if(result) {
            return "Yes";
        }
        return "No";
    }

    private static int rotate(int number, int digits) {
        int pow = (int)Math.pow(10, digits - 1);
        int firstNumber = number / pow;
        return ((number * 10) + firstNumber) - (firstNumber * pow * 10);
    }

    private static int numberOfDigits(int n) {
        int cnt = 0;
        while (n > 0) {
            cnt++;
            n /= 10;
        }
        return cnt;
    } 
}