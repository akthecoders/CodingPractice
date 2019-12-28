package Rotation;

import java.util.Scanner;

/**
 * QueriesForRotation Given a string str, the task is to perform the following
 * type of queries on the given string: (1, K): Left rotate the string by K
 * characters. (2, K): Print the Kth character of the string.
 */
public class QueriesForRotation {

    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        int r = scan.nextInt();
        int[][] query = new int[r][2];
        for( int i = 0; i < r; i++) {
            for(int j = 0; j < 2; j++) {
                query[i][j] = scan.nextInt();
            }
        }
        performQuery(str, str.length(), query, query.length);
        scan.close();
    }

    private static void performQuery(String str, int strLength, int[][] query, int queryLength) {
        int ptr = 0;
        for(int i = 0; i < queryLength; i++) {
            if(query[i][0] == 1) {
                ptr = (ptr + query[i][1]) % strLength;
            }
            else {
                int index = (ptr + query[i][1] - 1) % strLength;
                System.out.println(str.charAt(index));
            }
        }
    }
}