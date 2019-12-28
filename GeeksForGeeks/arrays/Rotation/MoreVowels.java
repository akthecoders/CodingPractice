package Rotation;

import java.util.Scanner;

/**
 * MoreVowels
 * Given a string str of even size N consisting of lowercase English alphabets. The task is to find the number of rotated strings of str which have more vowels in the first half than the second half.
 */
public class MoreVowels {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String stringAry = "";
        stringAry = scan.nextLine();
        scan.close();
        System.out.println(countNoOfVowels(stringAry));
    }

    private static int countNoOfVowels(String stringAry) {
        int ans = 0;
        int start = 0;
        int mid = 0;
        int end = 0;
        int strlen = stringAry.length() - 1;
        String str = stringAry + stringAry;
        for(int i = 0; i < stringAry.length(); i++) {
            start = i;
            end = strlen + i;
            mid = start + (stringAry.length() / 2);
            if(checkVowels(str, start, mid - 1) > checkVowels(str, mid, end)) {
                ans++;
            }
        }
        return ans;
    }

    private static int checkVowels(String str, int start, int end) {
        int vowels = 0;
        for(int i = start; i <= end; i++) {
            if (str.charAt(i) == 'a' || str.charAt(i) == 'e' ||  
            str.charAt(i) == 'i' || str.charAt(i) == 'o' ||  
            str.charAt(i) == 'u')  {
                vowels++;
            }
        }
        return vowels;
    }
}