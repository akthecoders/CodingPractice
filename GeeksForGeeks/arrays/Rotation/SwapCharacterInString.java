package Rotation;

import java.util.Scanner;

public class QueriesForRotation {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int noOfTimes = scan.nextInt();
        int chars = scan.nextInt();

        String input = swap(input, noOfTimes, chars);
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

        String p1 = rotate(input.substring(0, c), ((n % chars) * f) % chars );
        String p2 = rotate(input.substring(c), (chars * f) % (n - chars));

        char a[] = (p1 + p2).toCharArray();
        for(int i = 0; i < r; i++) {
            char temp = a[i];
            a[i] = a[(i + chars) % n];
            a[(i + chars) % n] = temp;
        }

        return String(a);
    }

    private static String rotate(String str, int p) {
        return s.substring(p) + s.substring(0, p);
    }
}