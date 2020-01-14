package RangeQueries;

/**
 * SumOfQueries
 */
public class SumOfQueries {

    public static void main(String[] args) {
        int a[] = {1, 1, 2, 1, 3, 4, 5, 2, 8}; 
        int q[][] = {{0, 4}, {1, 3}, {2, 4}}; 
        printQueries(a, q);
    }

    public static void printQueries(int[] arr, int[][] queries) {
        for(int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];
            int sum = 0;
            for(int j = left;j <= right; j++) {
                sum += arr[j];
            }
            System.out.println("Query " + (i + 1) + " : " + sum);
        }
    }
}