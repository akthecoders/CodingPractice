package Rotation;

/**
 * MinRotationsForSameString
 */
public class MinRotationsForSameString {

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(findRotations(str));
    }

    static int findRotations(String str) {
        String tmp = str + str;
        int n = str.length();

        for (int i = 1; i <= n; i++) {
            String substring = tmp.substring(i, str.length());
            if (str == substring)
                return i;
        }
        return n;
    }
}