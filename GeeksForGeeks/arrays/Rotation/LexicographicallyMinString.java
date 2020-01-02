package Rotation;

import java.util.Arrays;

/**
 * LexicographicallyMinString
 */
public class LexicographicallyMinString {

    public static void main(String[] args) {
        System.out.println(minLexRotation("GEEKSFORGEEKS")); 
        System.out.println(minLexRotation("GEEKSQUIZ")); 
        System.out.println(minLexRotation("BCABDADAB")); 
    }

    private static String minLexRotation(String str) {
       int n = str.length();
       String arr[] = new String[n];

       String concat = str + str;
       for(int i = 0; i < n; i++) {
           arr[i] = concat.substring(i, i + n);
       }

       Arrays.sort(arr);
       return arr[0];
    }
}