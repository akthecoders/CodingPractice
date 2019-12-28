package Rotation;

import java.util.Scanner;

/**
 * CountOddEvenRotation Given a number n, the task is to count all rotations of
 * the given number which are odd and even.
 */
public class CountOddEvenRotation {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        Result result = countOddEvenRotation(number);
        System.out.println("Odd : " + result.odd);
        System.out.println("Even : " + result.even);
        scan.close();
    }

    private static Result countOddEvenRotation(int number) {
        Result result = new Result();
        int temp = number;
        while(temp != 0) {
            int digit = temp % 10;
            if(digit % 2 == 0) {
                result.even++;
            }
            else {
                result.odd++;
            }
            temp = temp / 10;
        }
        return result;
    }
}

class Result {
    int odd;
    int even;
    public Result() {
        this.odd = 0;
        this.even = 0;
    }

}