public class PalindromePartitioning {
    public static void main(String[] args) {
        String input = "ababbbabbababa";
        System.out.println(solve(input, 0, input.length() - 1));
    }

    public static int solve(String input, int start, int end) {
        if(start >= end) return 0;
        if(isPalindrome(input, start, end)) {
            return 0;
        }
        int result = Integer.MAX_VALUE;
        for(int k = start; k <= end - 1; k++) {
            result = Math.min(result, 1 + solve(input, start, k) + solve(input, k + 1, end));
        }
        return result;
    }

    public static boolean isPalindrome(String input, int start, int end ) {
        if(start > end) return false;

        while(start < end) {
            if(input.charAt(start) != input.charAt(end)) return false;
            start++;
            end--;
        }
        return true;
    }
}