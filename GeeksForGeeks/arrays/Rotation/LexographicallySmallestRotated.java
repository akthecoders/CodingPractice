package Rotation;

/**
 * LexographicallySmallestRotated
 */
public class LexographicallySmallestRotated {

    public static void main(String[] args) {
        String S = "DCACBCAA";
        int n = 8;
        printSmallestSequence(S, n);
    }

    private static void printSmallestSequence(String str, int n) {
        char[] S = str.toCharArray();
        int starting_index = smallestSequence(S, n);
        for (int i = 0; i < n; i++) {
            System.out.print(S[(i + starting_index) % n]);
        }
    }

    private static int smallestSequence(char[] S, int n) {
        int index = 0;
        for (int i = 1; i < n; i++) {
            if (compareSeq(S, index, i, n)) {
                index = i;
            }
        }
        return index;
    }

    private static boolean compareSeq(char[] S, int x, int y, int n) {
        for (int i = 0; i < n; i++) {
            if (S[x] > S[y]) {
                return true;
            } else if (S[x] < S[y]) {
                return false;
            }
            x = (x + 1) % n;
            y = (y + 1) % n;
        }
        return true;
    }
}