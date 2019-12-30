package Rotation;

import java.util.Scanner;

public class SwapCharacterInString {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int noOfTimes = scan.nextInt();
        int chars = scan.nextInt();

        input = swap(input, noOfTimes, chars);
        System.out.println(input);
    }

    private static String swap(String input, int noOfTimes, int chars) {
        int n = input.length();
        chars = chars % n;

        if(chars == 0) {
            return input;
        }
        int f = noOfTimes / n;
        int r = noOfTimes % n;

        String p1 = rotate(input.substring(0, chars), ((n % chars) * f) % chars );
        String p2 = rotate(input.substring(chars), (chars * f) % (n - chars));

        char a[] = (p1 + p2).toCharArray();
        for(int i = 0; i < r; i++) {
            char temp = a[i];
            a[i] = a[(i + chars) % n];
            a[(i + chars) % n] = temp;
        }

        return new String(a);
    }

    private static String rotate(String str, int p) {
        return str.substring(p) + str.substring(0, p);
    }
}